package com.home.Selenide2.common.selenide.controls.input;

import com.codeborne.selenide.SelenideElement;
import com.home.Selenide2.common.robot.RobotUtils;

public class AbstractPicker
{
    protected final RobotUtils robotWrapper = RobotUtils.build();
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
