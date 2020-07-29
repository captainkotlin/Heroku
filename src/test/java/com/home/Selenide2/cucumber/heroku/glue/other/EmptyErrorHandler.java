package com.home.Selenide2.cucumber.heroku.glue.other;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class EmptyErrorHandler implements ResponseErrorHandler
{
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse)
    {
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse)
    {

    }
}
