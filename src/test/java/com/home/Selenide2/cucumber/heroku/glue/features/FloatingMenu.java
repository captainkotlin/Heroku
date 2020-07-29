package com.home.Selenide2.cucumber.heroku.glue.features;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class FloatingMenu
{
    @Then("menu has vertical offset")
    public void menuHasVerticalOffset()
    {
        int posY = $x("//a[@href='#home']").getCoordinates().inViewPort().getY();
        Assertions.assertTrue(posY > 0);
    }

    @When("page is scrolled down")
    public void pageIsScrolledDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");
    }

    @Then("menu has no vertical offset")
    public void menuHasNoVerticalOffset()
    {
        int posY = $x("//a[@href='#home']").getCoordinates().inViewPort().getY();
        Assertions.assertTrue(posY > 650);
    }
}
