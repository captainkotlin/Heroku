package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Selenide;
import com.home.selenide2.common.python.ImageParser;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.home.selenide2.common.selenide.actions.InBrowsersAction.inBrowsersAction;
import static junit.framework.TestCase.assertTrue;

public class ChallengingDom
{
    @Then("image contans {string} and some number")
    public void imageContansAndSomeNumber(String expectedStr) throws IOException, InterruptedException
    {
        var element = $x("/html/body/div[2]/div/div/div/div/div[2]/div/div");
        var coords = element.getCoordinates();
        var dimension = element.getSize();

        var imageFile = new File(Objects.requireNonNull(Selenide.screenshot("tmp")));
        var fullImage = ImageIO.read(imageFile);
        var subImage = fullImage.getSubimage(coords.inViewPort().getX(), coords.inViewPort().getY(), dimension.width, dimension.height);
        ImageIO.write(subImage, "png", imageFile);
        var imageParser = new ImageParser(imageFile.getPath());
        var result = imageParser.parse();

        inBrowsersAction(Browsers.CHROME).add(browser ->
        {
            var parts = Arrays.stream(result.split(" ")).map(String::trim).toArray(String[]::new);
            var preLastPart = parts[parts.length - 2];
            var lastPart = parts[parts.length - 1];
            assertTrue(StringUtils.endsWith(preLastPart, expectedStr));
            assertTrue(StringUtils.isNumeric(lastPart));
            return null;
        }).execute();
    }
}
