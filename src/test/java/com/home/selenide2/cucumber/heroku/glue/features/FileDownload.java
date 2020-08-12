package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.common.selenide.SelenideUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.download;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FileDownload
{
    private String fileName;

    @Given("url with list of files {string}")
    @SneakyThrows
    public void urlWithListOfFiles(String url)
    {
        SelenideUtils.open(url);
    }

    @When("href is pressed {string}")
    @SneakyThrows
    public void hrefIsPressed(String link) throws IOException, URISyntaxException
    {
        fileName = Paths.get(link).getFileName().toString();
        download("http://the-internet.herokuapp.com/download/" + fileName);
    }

    @Then("file is downloaded")
    @SneakyThrows
    public void fileIsDownloaded()
    {
        try (Stream<Path> paths = Files.list(Paths.get("./build/downloads")))
        {
            var foundFiles = paths.map(Path::getFileName)
                    .map(Path::toString)
                    .filter(path -> path.startsWith(fileName))
                    .collect(Collectors.toList());
            assertFalse(foundFiles.isEmpty());
        }
    }
}
