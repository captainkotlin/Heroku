package com.home.Selenide2.heroku.glue.features;

import com.home.Selenide2.common.beans.RestTemplateSilent;
import com.home.Selenide2.heroku.glue.pages.TablesPage;
import com.home.Selenide2.heroku.glue.other.EmptyErrorHandler;
import com.home.Selenide2.heroku.glue.entities.StatusCodeEntity;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class StatusCode
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;

    @Autowired
    private TablesPage page;

    @Then("status code of page matches expected:")
    public void statusCodeOfPageMatchesExpected(List<StatusCodeEntity> statusCodeEntities)
    {
        statusCodeEntities.forEach(entity ->
        {
            ResponseEntity<String> response = restTemplateSilent.getForEntity(entity.getUrl(), String.class);
            Assertions.assertEquals(response.getStatusCode().value(), entity.getStatusCode());
        });
    }
}
