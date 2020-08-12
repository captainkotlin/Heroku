package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.beans.RestTemplateSilent;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokenImages
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;

    @Then("image asdf contains real image under url")
    public void imageAsdfContainsRealImageUnderUrl()
    {
        String srcAttr = $x("//img[@src='asdf.jpg']").getAttribute("src");
        ResponseEntity<String> response = restTemplateSilent.getForEntity(Objects.requireNonNull(srcAttr), String.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
