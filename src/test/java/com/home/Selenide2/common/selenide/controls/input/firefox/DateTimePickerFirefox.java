package com.home.Selenide2.common.selenide.controls.input.firefox;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.selenide.controls.input.common.DateTimePicker;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

public class DateTimePickerFirefox extends DateTimePicker
{
    public DateTimePickerFirefox(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    @Override
    public DateTimePicker setDateTime(LocalDateTime localDateTime)
    {
        String localDateTimeStr = localDateTime.toString();
        selenideElement.click();
        robotWrapper.sendKeyWithModifiers(KeyEvent.VK_A, KeyEvent.VK_CONTROL);
        robotWrapper.sendKey(KeyEvent.VK_DELETE);
        selenideElement.setValue(localDateTimeStr);
        return this;
    }
}
