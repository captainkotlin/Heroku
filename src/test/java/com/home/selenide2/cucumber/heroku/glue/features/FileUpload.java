package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.utils.FileUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUpload
{
    @Given("path to file {string}")
    public void pathToFile(String filePath)
    {
        String absoluteFilePath = FileUtils.getProjectPath(filePath);
        $("#file-upload").setValue(absoluteFilePath);
    }

    @When("upload button pressed")
    public void uploadButtonPressed()
    {
        $("#file-submit").click();
    }

    @Then("^uploaded files contains (.*)")
    public void uploadedFilesContainsUpload(String expectedFileName)
    {
        var actualFileName = $("#uploaded-files").getText();
        assertEquals(expectedFileName, actualFileName);
    }
}
