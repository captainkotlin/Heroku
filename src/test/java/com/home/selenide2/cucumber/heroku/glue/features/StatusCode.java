package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.beans.RestTemplateSilent;
import com.home.selenide2.cucumber.heroku.glue.entities.StatusCodeEntity;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusCode
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;

    @Then("status code of page matches expected:")
    public void statusCodeOfPageMatchesExpected(List<StatusCodeEntity> statusCodeEntities)
    {
        statusCodeEntities.forEach(entity ->
        {
            var response = restTemplateSilent.getForEntity(entity.getUrl(), String.class);
            assertEquals(response.getStatusCode().value(), entity.getStatusCode());
        });
    }
}
