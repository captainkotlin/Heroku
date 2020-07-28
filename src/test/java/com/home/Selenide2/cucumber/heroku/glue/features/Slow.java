package com.home.Selenide2.cucumber.heroku.glue.features;

import com.home.Selenide2.common.beans.RestTemplateSilent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Slow
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;
    private final ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
    private String url;

    @Given("url is opened {string}")
    public void op(String url)
    {
        this.url = url;
    }

    @Then("page is opened in {int} seconds with status {int}")
    public void opd2(int seconds, int expectedStatus)
    {
        long startDate = getCurrentInstant();
        ResponseEntity<String> response = restTemplateSilent.getForEntity(url, String.class);
        long endDate = getCurrentInstant();
        long loadTime = endDate - startDate;
        Assertions.assertEquals(expectedStatus, response.getStatusCodeValue());
        Assertions.assertTrue(loadTime <= seconds);
    }

    private long getCurrentInstant()
    {
        return LocalDateTime.now().toEpochSecond(zoneOffset);
    }
}
