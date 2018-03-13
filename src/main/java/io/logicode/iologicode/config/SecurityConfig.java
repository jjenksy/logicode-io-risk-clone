package io.logicode.iologicode.config;


import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * Reactive security configuration
 */
@Configuration
public class SecurityConfig {

    //reactive security config
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        return http.authorizeExchange().matchers(EndpointRequest.toAnyEndpoint()).authenticated()
                .anyExchange().permitAll()
                .and().formLogin().and().httpBasic().and().build();
    }
}
