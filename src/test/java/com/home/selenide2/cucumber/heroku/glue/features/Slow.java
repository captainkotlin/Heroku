package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.beans.RestTemplateSilent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        var startDate = getCurrentInstant();
        var response = restTemplateSilent.getForEntity(url, String.class);
        var endDate = getCurrentInstant();
        var loadTime = endDate - startDate;
        assertEquals(expectedStatus, response.getStatusCodeValue());
        assertTrue(loadTime <= seconds);
    }

    private long getCurrentInstant()
    {
        return LocalDateTime.now().toEpochSecond(zoneOffset);
    }
}
