package com.marco.zuulserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStorage());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //rules priority is from top to bottom
        http.authorizeRequests()
            .antMatchers("/api/security/oauth/**").permitAll()
            .antMatchers(HttpMethod.GET,
                    "/api/products/products",
                    "/api/stock/stock",
                    "/api/users/users").permitAll()
            .antMatchers(HttpMethod.GET,
                    "/api/products/products/{id}",
                    "/api/stock/stock/{id}",
                    "/api/users/users/{id}").hasAnyRole("ADMIN", "USER")
            .antMatchers(//rest of verbs
                    "/api/products/**",
                    "/api/stock/**",
                    "/api/users/**").hasRole("ADMIN")
            .anyRequest().authenticated();
    }

    @Bean
    public JwtTokenStore tokenStorage() {
        return new JwtTokenStore(accessTokenComverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenComverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("secret_key"); //TODO extract jwt key to config server
        return tokenConverter;
    }
}
