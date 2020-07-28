package com.home.Selenide2.cucumber.heroku.glue.features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class FileUpload
{
    @Given("path to file {string}")
    public void pathToFile(String filePath)
    {
        $("#file-upload").setValue(filePath);
    }

    @When("upload button pressed")
    public void uploadButtonPressed()
    {
        $("#file-submit").click();
    }

    @Then("^uploaded files contains (.*)")
    public void uploadedFilesContainsUpload(String expectedFileName)
    {
        String actualFileName = $("#uploaded-files").getText();
        Assertions.assertEquals(expectedFileName, actualFileName);
    }
}
