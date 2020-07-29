package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.home.Selenide2.common.Constants;
import com.home.Selenide2.common.utils.ImageParser;
import com.home.Selenide2.common.utils.WebDriverLocator;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Coordinates;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChallengingDom
{
    @Value("${" + Constants.WEBDRIVER_CHROME_DRIVER + "}")
    private String driverPath;

    @Before
    public void before()
    {
        System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, WebDriverLocator.getPath(Browsers.CHROME));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }

    @Then("image contans {string} and some number")
    public void imageContansAndSomeNumber(String arg0) throws IOException, InterruptedException
    {
        SelenideElement element = $x("/html/body/div[2]/div/div/div/div/div[2]/div/div");
        Coordinates coords = element.getCoordinates();
        Dimension dimension = element.getSize();

        File imageFile = new File(Objects.requireNonNull(Selenide.screenshot("tmp.png")));
        BufferedImage fullImage = ImageIO.read(imageFile);
        BufferedImage subImage = fullImage.getSubimage(coords.inViewPort().getX(), coords.inViewPort().getY(), dimension.width, dimension.height);
        ImageIO.write(subImage, "png", imageFile);
        ImageParser imageParser = new ImageParser(imageFile.getPath());
        String result = imageParser.parse();
        String[] parts = Arrays.stream(result.split(" ")).map(String::trim).toArray(String[]::new);
        assertEquals(arg0, parts[0]);
        assertTrue(StringUtils.isNumeric(parts[1]));
    }
}
