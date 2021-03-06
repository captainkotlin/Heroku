package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.home.selenide2.common.beans.RestTemplateSilent;
import com.home.selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftingContent
{
    @Autowired
    private RestTemplateSilent restTemplateSilent;
    @Value("${screenshots.folder}")
    private String screenshotsFolder;

    private static final String expectedScreenshotName = "screen1";
    private final String actualScreenshotName = "screen2";

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true);

    @Given("screenshot opened {string}")
    public void screenshotOpened(String url)
    {
        SelenideUtils.open(url);
        SelenideUtils.screenshot(expectedScreenshotName);
    }

    @When("^page (.*) is opened$")
    public void pageScreenshotUrlIsOpened(String url)
    {
        SelenideUtils.open(url);
        SelenideUtils.screenshot(actualScreenshotName);
    }

    @Then("^comparisonStatus is (.*)$")
    public void comparisonstatusIsComparisonStatus(boolean comparisonStatus) throws IOException
    {
        var ext = ".png";
        var first = Files.readAllBytes(Paths.get(screenshotsFolder + expectedScreenshotName + ext));
        var second = Files.readAllBytes(Paths.get(screenshotsFolder + actualScreenshotName + ext));
        assertEquals(comparisonStatus, Arrays.equals(first, second));
    }
}
