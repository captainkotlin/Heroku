package com.home.Selenide2.common.selenide.controls.input.common;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.selenide.controls.input.AbstractPicker;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ColorPicker extends AbstractPicker
{
    public ColorPicker(SelenideElement selenideElement)
    {
        super(selenideElement);
    }

    public static ColorPicker of(SelenideElement selenideElement)
    {
        return new ColorPicker(selenideElement);
    }

    public ColorPicker setColor(String color)
    {
        String jsCode = String.format("arguments[0].setAttribute('value', '%s')", color);
        executeJavaScript(jsCode, selenideElement);
        return this;
    }
}
