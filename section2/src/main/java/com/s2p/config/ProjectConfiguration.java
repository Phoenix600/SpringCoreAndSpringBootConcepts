package com.s2p.config;

import com.s2p.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
**/
@Configuration
public class ProjectConfiguration
{
    /*
    @Bean annotation, which lets Spring know that it needs to call
    this method when it initializes its context and adds the returned
    value to the context.
    **/
    @Bean
    Vehicle vehicle()
    {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setName("Tesla");
        return vehicle1;
    }

    @Bean
    String hello()
    {
        return "Hello World";
    }

    @Bean
    Integer number() {
        return 16;
    }
}
