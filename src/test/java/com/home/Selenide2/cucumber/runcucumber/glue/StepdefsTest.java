package com.home.Selenide2.cucumber.runcucumber.glue;

import com.home.Selenide2.service.MyService;
import io.cucumber.java.ParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IsItFriday
{
    static String isItFriday(String today)
    {
        return "Friday".equals(today) ? "Yes" : "Nope";
    }
}

public class StepdefsTest
{
    @Autowired
    private MyService myService;

    private String today;
    private String actualAnswer;

    @PostConstruct
    private void postConstruct()
    {
        myService.sayService();
//        Before(() ->
//        {
//            System.out.println("Before scenario");
//        });
//        Given("Background here", () ->
//        {
//            System.out.println("Background");
//        });
//
//        Given("today is {string}", this::setDay);
//        When("I ask whether it's Friday yet", this::getActualAnswer);
//        Then("I should be told {string}", this::checkActualAnswer);
//        After((scenario ->
//        {
//            System.out.println("After scenario");
//        }));
//        BeforeStep((scenario ->
//        {
//            System.out.println("Before step");
//        }));
//        AfterStep((scenario ->
//        {
//            System.out.println("After step");
//        }));


    }

    private void setDay(String day)
    {
        today = day;
    }

    private void getActualAnswer()
    {
        System.out.println("Hello");
        actualAnswer = IsItFriday.isItFriday(today);
    }

    private void checkActualAnswer(String expectedAnswer)
    {
        System.out.println("Hello");
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterType("red|blue|yellow")  // regexp
    public Color color(String color){  // type, name (from method)
        return new Color(color);       // transformer function
    }

    class Color
    {
        Color(String str)
        {

        }
    }
}

