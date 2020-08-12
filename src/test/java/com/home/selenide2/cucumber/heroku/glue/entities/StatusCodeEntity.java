package com.home.selenide2.cucumber.heroku.glue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusCodeEntity
{
    private String url;
    private int statusCode;
}
