/*
From Andreas Martin FHNW
https://github.com/DigiPR/digipr-acrm
 */

package com.unchained.Unchained.security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import com.unchained.Unchained.security.config.TokenSecurityProperties;
import com.unchained.Unchained.security.service.TokenService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenLogoutHandler implements LogoutHandler {

    private TokenService tokenService;

    public TokenLogoutHandler(TokenService tokenService) {
        super();
        this.tokenService = tokenService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(TokenSecurityProperties.COOKIE_NAME)) {
                    tokenService.blacklistToken(cookie.getValue());
                }
                cookie.setPath(request.getContextPath() + "/");
                cookie.setMaxAge(0);
                cookie.setValue(null);
                response.addCookie(cookie);
            }
        }

        String token = request.getHeader(TokenSecurityProperties.HEADER_NAME);
        if (token != null) {
            token = token.replace(TokenSecurityProperties.BEARER_TOKEN_PREFIX, "");
            tokenService.blacklistToken(token);
        }
    }
}
