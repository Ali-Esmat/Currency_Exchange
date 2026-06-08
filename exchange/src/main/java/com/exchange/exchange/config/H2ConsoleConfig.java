package com.exchange.exchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;


@Configuration
public class H2ConsoleConfig {
    @Bean
    public ServletRegistrationBean <JakartaWebServlet> h2Console(){
        JakartaWebServlet servlet = new JakartaWebServlet();
        ServletRegistrationBean <JakartaWebServlet> bean = new ServletRegistrationBean<>(servlet, "/h2-console/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
