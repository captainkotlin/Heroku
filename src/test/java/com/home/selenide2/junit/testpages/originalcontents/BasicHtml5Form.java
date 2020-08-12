package com.home.selenide2.junit.testpages.originalcontents;

import com.home.selenide2.common.selenide.SelenideUtils;
import com.home.selenide2.junit.testpages.originalcontents.page.FormPage;
import com.home.selenide2.junit.testpages.originalcontents.page.SubmittedPage;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicHtml5Form
{
    private static FormPage formPage;

    @BeforeEach
    public void beforeEach()
    {
        formPage = SelenideUtils.open("https://testpages.herokuapp.com/basic_html5_form.html", FormPage.class);
    }

    @Test
    public void submitTest()
    {
        var expectedColor = "#0000ff";
        var expectedDate = LocalDate.now();
        var expectedDateTime = LocalDateTime.of(expectedDate, LocalTime.MIN);
        var expectedEmail = "johny@mnemonic.com";
        var expectedMonth = "03";
        var expectedYear = "2020";
        var expectedNumber = "42";

        SubmittedPage submittedPage = formPage
                .setColor(expectedColor)
                .setDate(expectedDate)
                .setDateTime(expectedDateTime)
                .setEmail(expectedEmail)
                .setMonthAndYear(expectedMonth, expectedYear)
                .setNumber(expectedNumber)
                .sumbitForm();
        assertEquals(expectedColor, submittedPage.getColor());
        assertEquals(expectedDate, submittedPage.getDate());
        assertEquals(expectedDateTime, submittedPage.getDateTime());
        assertEquals(expectedEmail, submittedPage.getEmail());
        assertEquals(expectedMonth, submittedPage.getMonth());
        assertEquals(expectedYear, submittedPage.getYear());
        assertEquals(expectedNumber, submittedPage.getNumber());
    }
}
