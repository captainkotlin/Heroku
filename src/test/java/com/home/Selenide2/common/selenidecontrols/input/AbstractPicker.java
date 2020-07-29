package com.home.Selenide2.common.selenidecontrols.input;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.RobotWrapper;

public class AbstractPicker
{
    protected final RobotWrapper robotWrapper = RobotWrapper.build();
    protected final SelenideElement selenideElement;

    public AbstractPicker(SelenideElement selenideElement)
    {
        this.selenideElement = selenideElement;
    }

    public SelenideElement toSelenideElement()
    {
        return selenideElement;
    }
}
