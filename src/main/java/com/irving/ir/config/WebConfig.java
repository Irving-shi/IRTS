package com.irving.ir.config;

import com.irving.ir.common.util.JwtUtils;
import com.irving.ir.componet.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author irving
 * @date 2021/6/19
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor(jwtUtils));
    }
}
