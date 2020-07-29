package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$x;

public class FileDownload
{
    private String fileName;

    @Given("url with list of files {string}")
    @SneakyThrows
    public void urlWithListOfFiles(String url)
    {
        Selenide.open(url);
        File f = Selenide.download("http://the-internet.herokuapp.com/download/EAWeekly.png");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.prompt_for_download", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        Selenide.open(url);
    }

    @When("href is pressed {string}")
    public void hrefIsPressed(String link)
    {
        fileName = Paths.get(link).getFileName().toString();
        $x("//a[@href='" + link + "']").click();
    }

    @Then("file is downloaded")
    @SneakyThrows
    public void fileIsDownloaded()
    {
        try (Stream<Path> s = Files.list(Paths.get("/home/alexander/Downloads")))
        {
            List<String> foundFiles = s.map(Path::getFileName)
                    .map(Path::toString)
                    .filter(r -> r.startsWith(fileName))
                    .collect(Collectors.toList());
            Assertions.assertFalse(foundFiles.isEmpty());
        }
    }
}
