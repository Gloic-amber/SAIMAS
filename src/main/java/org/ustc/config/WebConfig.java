package org.ustc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.ustc.interceptor.JwtInterceptor;

/**
 * ClassName: WebConfig
 * Package: org.ustc.config
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/user/**", "/evaluate/**")  // 指定拦截器要拦截的路径
                .excludePathPatterns("/user/login", "/user/register");  // 指定拦截器不拦截的路径
    }
}
