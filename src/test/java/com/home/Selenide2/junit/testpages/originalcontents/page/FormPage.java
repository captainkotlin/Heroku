package com.home.Selenide2.junit.testpages.originalcontents.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.RobotWrapper;
import com.home.Selenide2.common.selenidecontrols.input.ColorPicker;
import com.home.Selenide2.common.selenidecontrols.input.DatePicker;
import com.home.Selenide2.common.selenidecontrols.input.DateTimePicker;
import com.home.Selenide2.common.selenidecontrols.input.MonthPicker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class FormPage
{
    @FindBy(how = How.CSS, css = "input[type='color']")
    private SelenideElement colorPicker;

    @FindBy(how = How.CSS, css = "input[type='date']")
    private SelenideElement datePicker;

    @FindBy(how = How.CSS, css = "input[type='datetime-local']")
    private SelenideElement dateTimePicker;

    @FindBy(how = How.CSS, css = "input[type='email']")
    private SelenideElement emailPicker;

    @FindBy(how = How.CSS, css = "input[type='month']")
    private SelenideElement monthPicker;

    @FindBy(how = How.CSS, css = "input[type='number']")
    private SelenideElement numberPicker;

    @FindBy(how = How.CSS, css = "input[type='submit']")
    private SelenideElement submitButton;

    @FindBy(how = How.CSS, css = "input[type='reset']")
    private SelenideElement resetButton;

    private RobotWrapper robotWrapper = RobotWrapper.build();

    public FormPage setColor(String color)
    {
        return operation(() -> ColorPicker.of(colorPicker).setColor(color));
    }

    public FormPage setDate(LocalDate localDate)
    {
        return operation(() -> DatePicker.of(datePicker).setDate(localDate));
    }

    public FormPage setDateTime(LocalDateTime localDateTime)
    {
        return operation(() -> DateTimePicker.of(dateTimePicker).setDateTime(localDateTime));
    }

    public FormPage setEmail(String email)
    {
        return operation(() -> emailPicker.setValue(email));
    }

    public FormPage setMonthAndYear(String month, String year)
    {
        return operation(() -> MonthPicker.of(monthPicker).setMonthAndYear(month, year));
    }

    public FormPage setNumber(String number)
    {
        return operation(() -> numberPicker.setValue(number));
    }

    public SubmittedPage sumbitForm()
    {
        submitButton.click();
        return Selenide.page(SubmittedPage.class);
    }

    private FormPage operation(Supplier supplier)
    {
        supplier.get();
        return this;
    }
}
