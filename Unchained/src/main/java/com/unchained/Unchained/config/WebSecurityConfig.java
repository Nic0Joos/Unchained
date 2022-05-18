/*
From Andreas Martin FHNW
https://github.com/DigiPR/digipr-acrm
 */

package com.unchained.Unchained.config;

import com.unchained.Unchained.Service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.unchained.Unchained.security.config.EnableTokenSecurity;
import com.unchained.Unchained.security.service.TokenService;
import com.unchained.Unchained.security.web.CSRFRequestMatcher;
import com.unchained.Unchained.security.web.TokenAuthenticationFilter;
import com.unchained.Unchained.security.web.TokenLoginFilter;
import com.unchained.Unchained.security.web.TokenLogoutHandler;


@EnableWebSecurity
@EnableTokenSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImp userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/").permitAll();

        /*http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure().and() // If the X-Forwarded-Proto header is present, redirect to HTTPS (Heroku)
                .csrf()
                .requireCsrfProtectionMatcher(new CSRFRequestMatcher())
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .antMatchers("/", "/index", "/index.html", "/css/**", "/bootstrap/**", "/js/**", "/img/**", "/login.html", "/login/**", "/register.html", "/register/**", "/api/**").permitAll()
                .antMatchers("/costrequest/**", "/shop.html", "/customer.html", "/admin.html", "/order/**", "/product/**", "/user/**", "/validate", "/admin/**").authenticated()
                .antMatchers(HttpMethod.GET, "/logout").permitAll()
                .anyRequest().authenticated().and()
                .addFilter(new TokenLoginFilter(authenticationManagerBean(), tokenService))
                .addFilter(new TokenAuthenticationFilter(authenticationManagerBean(), tokenService))
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .addLogoutHandler(new TokenLogoutHandler(tokenService));
*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}