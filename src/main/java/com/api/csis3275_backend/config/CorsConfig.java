package com.api.csis3275_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // Allow requests from 'http://localhost:3000'
        config.addAllowedOrigin("http://localhost:3000");

        // Allow all origins, methods, and headers
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        // Optional: Allow credentials (e.g., cookies)
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
