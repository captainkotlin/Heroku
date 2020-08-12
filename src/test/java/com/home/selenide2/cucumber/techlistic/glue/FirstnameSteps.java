package com.home.selenide2.cucumber.techlistic.glue;

import com.home.selenide2.cucumber.techlistic.glue.background.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstnameSteps
{
    @Autowired
    private Page page;
    private String expectedVal;

    @Given("^'First name' field is selected$")
    public void selectFirstname()
    {
        page.firstname().click();
    }

    @When("^text (.*) was sent to 'First name'$")
    public void setExpectedVal(String expectedVal)
    {
        this.expectedVal = expectedVal;
        page.firstname().setValue(expectedVal);
    }

    @Then("^'First name' is (.*)")
    public void checkExpectations(String actualVal)
    {
        assertEquals(expectedVal, actualVal);
    }
}
