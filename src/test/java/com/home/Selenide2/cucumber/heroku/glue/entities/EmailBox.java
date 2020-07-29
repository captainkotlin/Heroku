package com.home.Selenide2.cucumber.heroku.glue.entities;

import lombok.Data;

@Data
public class EmailBox
{
    private String host;
    private String protocol;
    private String email;
    private String password;

    public EmailBox(String... args)
    {
        int i = 0;
        host = args[i++];
        protocol = args[i++];
        email = args[i++];
        password = args[i];
    }
}
