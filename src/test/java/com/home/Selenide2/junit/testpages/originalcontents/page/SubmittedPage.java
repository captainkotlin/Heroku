package com.home.Selenide2.junit.testpages.originalcontents.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SubmittedPage
{
    @FindBy(how = How.ID, id = "_valuecolour")
    private SelenideElement colorField;

    @FindBy(how = How.ID, id = "_valuedate")
    //@FindBy(how = How.ID, id = "_valuedate")
    private SelenideElement dateField;

    @FindBy(how = How.ID, id = "_valuedatetime")
    private SelenideElement dateTimeField;

    @FindBy(how = How.ID, id = "_valueemail")
    private SelenideElement emailField;

    @FindBy(how = How.ID, id = "_valuemonth")
    private SelenideElement monthField;

    @FindBy(how = How.ID, id = "_valuenumber")
    private SelenideElement numberField;

    public String getColor()
    {
        return colorField.getText();
    }

    public LocalDate getDate()
    {
        DateTimeFormatter actualFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateField.getText(), actualFormatter);
    }

    public LocalDateTime getDateTime()
    {
        return LocalDateTime.parse(dateTimeField.getText());
    }

    public String getEmail()
    {
        return emailField.getText();
    }

    public String getMonth()
    {
        return monthField.getText().split("-")[1];
    }

    public String getYear()
    {
        return monthField.getText().split("-")[0];
    }

    public String getNumber()
    {
        return numberField.getText();
    }
}
