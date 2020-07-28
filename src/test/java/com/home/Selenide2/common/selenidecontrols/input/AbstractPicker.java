package com.home.Selenide2.common.selenidecontrols.input;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.RobotWrapper;

public class AbstractPicker
{
    protected RobotWrapper robotWrapper = RobotWrapper.build();
    protected SelenideElement selenideElement;

    public AbstractPicker(SelenideElement selenideElement)
    {
        this.selenideElement = selenideElement;
    }

    public SelenideElement toSelenideElement()
    {
        return selenideElement;
    }
}
