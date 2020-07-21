package com.home.Selenide2.common.beans;

import com.home.Selenide2.heroku.glue.other.EmptyErrorHandler;
import org.springframework.web.client.RestTemplate;

public class RestTemplateSilent extends RestTemplate
{
    public RestTemplateSilent()
    {
        setErrorHandler(new EmptyErrorHandler());
    }
}
