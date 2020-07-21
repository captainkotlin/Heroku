package com.home.Selenide2.service;

import org.springframework.stereotype.Service;

@Service
public class MyService
{
    public String sayService()
    {
        return this.getClass().getSimpleName();
    }
}
