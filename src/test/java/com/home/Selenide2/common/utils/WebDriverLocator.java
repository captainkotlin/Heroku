package com.home.Selenide2.common.utils;

import org.apache.commons.lang3.SystemUtils;

public class WebDriverLocator
{
    public static String getPath(String browserName)
    {
        String driverName = toDriverName(browserName);
        StringBuilder webDriverPath = new StringBuilder("./drivers/");
        if (SystemUtils.IS_OS_WINDOWS)
        {
            webDriverPath.append("windows/");
            webDriverPath.append(driverName);
            webDriverPath.append(".exe");
        }
        else if (SystemUtils.IS_OS_LINUX)
        {
            webDriverPath.append("linux/");
            webDriverPath.append(driverName);
        }
        else
        {
            throw new RuntimeException("Not supported operation system");
        }
        return webDriverPath.toString();
    }

    private static String toDriverName(String browserName)
    {
        return browserName + "driver";
    }
}
