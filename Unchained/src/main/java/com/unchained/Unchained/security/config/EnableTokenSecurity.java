/*
From Andreas Martin FHNW
https://github.com/DigiPR/digipr-acrm
 */

package com.unchained.Unchained.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.unchained.Unchained.security.service.TokenService;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({TokenSecurityConfiguration.class,
        TokenSecurityProperties.class,
        TokenService.class})
@Configuration
public @interface EnableTokenSecurity {
}
