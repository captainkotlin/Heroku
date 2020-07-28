package com.home.Selenide2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.home.Selenide2.service")
public class Selenide2Application
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext ctx = SpringApplication.run(Selenide2Application.class, args);
        System.out.println("Hello");
    }
}
