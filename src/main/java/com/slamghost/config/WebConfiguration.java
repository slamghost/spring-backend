package com.slamghost.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.slamghost.controller"})

public class WebConfiguration implements WebMvcConfigurer{

	
}
