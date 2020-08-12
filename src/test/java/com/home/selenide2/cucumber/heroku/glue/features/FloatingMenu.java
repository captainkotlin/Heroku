package com.home.selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloatingMenu
{
    @Then("menu has vertical offset")
    public void menuHasVerticalOffset()
    {
        var posY = $x("//a[@href='#home']").getCoordinates().inViewPort().getY();
        assertTrue(posY > 0);
    }

    @When("page is scrolled down")
    public void pageIsScrolledDown()
    {
        var driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");
    }

    @Then("menu has no vertical offset")
    public void menuHasNoVerticalOffset()
    {
        var posY = $x("//a[@href='#home']").getCoordinates().inViewPort().getY();
        assertTrue(posY > 600);
    }
}
