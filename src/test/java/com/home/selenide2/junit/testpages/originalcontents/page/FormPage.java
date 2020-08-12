package com.home.selenide2.junit.testpages.originalcontents.page;

import com.codeborne.selenide.SelenideElement;
import com.home.selenide2.common.selenide.controls.input.common.ColorPicker;
import com.home.selenide2.common.selenide.controls.input.common.DatePicker;
import com.home.selenide2.common.selenide.controls.input.common.DateTimePicker;
import com.home.selenide2.common.selenide.controls.input.common.MonthPicker;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.page;

public class FormPage
{
    @FindBy(css = "input[type='color']")
    private SelenideElement colorPicker;

    @FindBy(css = "input[type='date']")
    private SelenideElement datePicker;

    @FindBy(css = "input[type='datetime-local']")
    private SelenideElement dateTimePicker;

    @FindBy(css = "input[type='email']")
    private SelenideElement emailPicker;

    @FindBy(css = "input[type='month']")
    private SelenideElement monthPicker;

    @FindBy(css = "input[type='number']")
    private SelenideElement numberPicker;

    @FindBy(css = "input[type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = "input[type='reset']")
    private SelenideElement resetButton;

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
        return page(SubmittedPage.class);
    }

    private <T> FormPage operation(Supplier<T> supplier)
    {
        supplier.get();
        return this;
    }
}
