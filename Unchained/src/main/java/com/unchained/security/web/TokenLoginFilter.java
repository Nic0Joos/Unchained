/*
From Andreas Martin FHNW
https://github.com/DigiPR/digipr-acrm
 */

package com.unchained.security.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unchained.Unchained.Service.LoggerService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.unchained.security.config.TokenSecurityProperties;
import com.unchained.security.model.TokenUser;
import com.unchained.security.service.TokenService;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
    private TokenService tokenService;
    private TokenUser user = null;
    private LoggerService loggerService;

    public TokenLoginFilter(AuthenticationManager authenticationManager, TokenService tokenService) {
        super.setAuthenticationManager(authenticationManager);
        this.tokenService = tokenService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) {

        try {
            this.user = new ObjectMapper().readValue(request.getInputStream(), TokenUser.class);
        } catch (IOException e) {
            loggerService.logUser("Unsucessful login from user: "+ user);
        }

        return this.getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        Date date = null;
        Cookie cookie = null;
        loggerService.logUser("User: " + user + "logged in");

        if(Boolean.parseBoolean(this.user.getRemember())) {
            date = new Date(System.currentTimeMillis() + TokenSecurityProperties.REMEMBER_EXPIRATION_TIME);
        }else{
            date = new Date(System.currentTimeMillis() + TokenSecurityProperties.SESSION_EXPIRATION_TIME);
        }
        String cookieToken = this.tokenService.issueToken(this.user.getEmail(), TokenSecurityProperties.COOKIE_TYPE, date);
        cookie = new Cookie(TokenSecurityProperties.COOKIE_NAME, cookieToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        if(Boolean.parseBoolean(this.user.getRemember())) {
            cookie.setMaxAge(Math.toIntExact(TokenSecurityProperties.REMEMBER_EXPIRATION_TIME /1000));
        }
        response.addCookie(cookie);

        date = new Date(System.currentTimeMillis() + TokenSecurityProperties.BEARER_EXPIRATION_TIME);
        String bearerToken = this.tokenService.issueToken(this.user.getEmail(), TokenSecurityProperties.BEARER_TYPE, date);
        response.addHeader(TokenSecurityProperties.HEADER_NAME, TokenSecurityProperties.BEARER_TOKEN_PREFIX + bearerToken);
    }
}
