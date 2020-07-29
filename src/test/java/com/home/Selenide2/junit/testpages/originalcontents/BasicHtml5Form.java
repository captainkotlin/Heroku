package com.home.Selenide2.junit.testpages.originalcontents;

import com.codeborne.selenide.WebDriverRunner;
import com.home.Selenide2.common.RobotWrapper;
import com.home.Selenide2.junit.testpages.originalcontents.page.FormPage;
import com.home.Selenide2.junit.testpages.originalcontents.page.SubmittedPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.codeborne.selenide.Selenide.open;

@SpringBootTest(classes = RobotWrapper.class)
public class BasicHtml5Form
{
    private static FormPage formPage;

    @BeforeEach
    public void beforeAll()
    {
        formPage = open("https://testpages.herokuapp.com/basic_html5_form.html", FormPage.class);
    }

    @Test
    public void submitTest()
    {
        String expectedColor = "#ff0000";
        LocalDate expectedDate = LocalDate.now();
        LocalDateTime expectedDateTime = LocalDateTime.of(expectedDate, LocalTime.MIN);
        String expectedEmail = "johny@mnemonic.com";
        String expectedMonth = "03";
        String expectedYear = "2020";
        String expectedNumber = "42";

        SubmittedPage submittedPage = formPage
                .setColor(expectedColor)
                .setDate(expectedDate)
                .setDateTime(expectedDateTime)
                .setEmail(expectedEmail)
                .setMonthAndYear(expectedMonth, expectedYear)
                .setNumber(expectedNumber)
                .sumbitForm();
        Assertions.assertEquals(expectedColor, submittedPage.getColor());
        Assertions.assertEquals(expectedDate, submittedPage.getDate());
        Assertions.assertEquals(expectedDateTime, submittedPage.getDateTime());
        Assertions.assertEquals(expectedEmail, submittedPage.getEmail());
        Assertions.assertEquals(expectedMonth, submittedPage.getMonth());
        Assertions.assertEquals(expectedYear, submittedPage.getYear());
        Assertions.assertEquals(expectedNumber, submittedPage.getNumber());
    }

    @AfterAll
    public static void close()
    {
        WebDriverRunner.closeWebDriver();
    }
}
