package com.home.Selenide2.common.selenidecontrols.input;

import com.codeborne.selenide.SelenideElement;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

public class DateTimePicker extends AbstractPicker
{
    public DateTimePicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static DateTimePicker of(SelenideElement selenideElement)
    {
        return new DateTimePicker(selenideElement);
    }

    public DateTimePicker setDateTime(LocalDateTime localDateTime)
    {
        String localDateTimeStr = localDateTime.toString();
        String[] dateAndTime = localDateTimeStr.split("T");
        String[] dateParts = dateAndTime[0].split("-");
        String[] timeParts = dateAndTime[1].split(":");
        selenideElement.click();
        robotWrapper.sendKey(KeyEvent.VK_LEFT, 3);
        int i = 0;
        String year = dateParts[i++];
        String month = dateParts[i++];
        String day = dateParts[i++];
        robotWrapper.sendKey(month);
        robotWrapper.sendKey(day);
        robotWrapper.sendKey(year);
        robotWrapper.sendKey(KeyEvent.VK_RIGHT);
        i = 0;
        robotWrapper.sendKey(timeParts[i++]);
        robotWrapper.sendKey(timeParts[i++]);
        return this;
    }
}
