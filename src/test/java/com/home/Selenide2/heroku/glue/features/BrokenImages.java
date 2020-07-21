package com.home.Selenide2.heroku.glue.features;

import com.home.Selenide2.common.beans.RestTemplateSilent;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static com.codeborne.selenide.Selenide.$x;

public class BrokenImages
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;

    @Then("image asdf contains real image under url")
    public void imageAsdfContainsRealImageUnderUrl()
    {
        String srcAttr = $x("//img[@src='asdf.jpg']").getAttribute("src");
        ResponseEntity<String> response = restTemplateSilent.getForEntity(srcAttr, String.class);
        Assertions.assertTrue(response.getStatusCode().is4xxClientError());
    }
}
