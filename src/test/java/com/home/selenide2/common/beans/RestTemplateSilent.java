package com.home.selenide2.common.beans;

import com.home.selenide2.cucumber.heroku.glue.other.EmptyErrorHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateSilent extends RestTemplate
{
    public RestTemplateSilent()
    {
        setErrorHandler(new EmptyErrorHandler());
    }
}
