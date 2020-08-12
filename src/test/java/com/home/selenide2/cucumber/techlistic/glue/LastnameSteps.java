package com.home.selenide2.cucumber.techlistic.glue;

import com.home.selenide2.cucumber.techlistic.glue.background.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastnameSteps
{
    @Autowired
    private Page back;
    private String expectedVal;

    @Given("'Last name' field is selected")
    public void selectFirstname()
    {
        back.lastname().click();
    }

    @When("^text (.*) was sent to 'Last name'$")
    public void setExpectedVal(String expectedVal)
    {
        this.expectedVal = expectedVal;
        back.lastname().setValue(expectedVal);
    }

    @Then("^'Last name' is (.*)")
    public void checkExpectations(String actualVal)
    {
        assertEquals(expectedVal, actualVal);
    }
}
