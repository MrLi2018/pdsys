package com.demo.pdsys.config;

import com.demo.pdsys.component.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author MrLi2019
 * @date 2020-04-07
 * 跨域信息配置以及拦截器配置
 */
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {
    @Autowired
    private LoginInterceptor loginInterceptor;

   /* @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
    }*/

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /*super.addInterceptors(registry);*/
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("*/login");
    }

    @Bean
    public CorsConfiguration cors() {
        return new CorsConfiguration();
    }

    private CorsConfiguration corsConfiguration() {
        cors().addAllowedMethod("*");
        cors().addAllowedOrigin("*");
        cors().addAllowedHeader("*");
        cors().setAllowCredentials(true);
        return cors();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration());
        return new CorsFilter(source);

    }
}
