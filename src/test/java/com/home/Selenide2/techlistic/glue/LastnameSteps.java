package com.home.Selenide2.techlistic.glue;

import com.home.Selenide2.techlistic.glue.background.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

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
        Assertions.assertEquals(expectedVal, actualVal);
    }
}
