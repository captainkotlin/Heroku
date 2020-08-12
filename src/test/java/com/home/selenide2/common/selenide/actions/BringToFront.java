package com.home.selenide2.common.selenide.actions;

import com.home.selenide2.common.autoit.AutoItUtils;

import java.io.File;

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
        AutoItUtils.execute(browserName + File.separator + "bringToFront");
        return null;
    }
}
