package com.home.Selenide2.common.selenide.actions;

import com.home.Selenide2.common.autoit.AutoItUtils;

public class BringToFront extends AbstractAction<Void>
{
    private String browserName;

    public BringToFront(String browserName)
    {
        this.browserName = browserName;
    }

    @Override
    public Void perform()
    {
        AutoItUtils.execute(browserName + "\\" + "bringToFront");
        return null;
    }
}
