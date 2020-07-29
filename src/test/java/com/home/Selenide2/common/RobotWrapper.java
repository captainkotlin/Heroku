package com.home.Selenide2.common;

import lombok.SneakyThrows;
import lombok.Synchronized;

import java.awt.*;
import java.util.stream.IntStream;

public class RobotWrapper extends Robot
{
    static
    {
        System.setProperty("java.awt.headless", "false");
    }

    private static RobotWrapper robotWrapper;

    @Synchronized
    @SneakyThrows
    public static RobotWrapper build()
    {
        if (robotWrapper == null)
        {
            try
            {
                robotWrapper = new RobotWrapper();
            }
            catch (AWTException e)
            {
                throw new RuntimeException();
            }
        }
        return robotWrapper;
    }

    private RobotWrapper() throws AWTException
    {
        super();
    }

    public void sendKey(String key)
    {
        key.chars().forEach(keyCode ->
        {
            this.keyPress(keyCode);
            this.keyRelease(keyCode);
        });
    }

    public void sendKey(int keyCode)
    {
        this.keyPress(keyCode);
        this.keyRelease(keyCode);
    }

    public void sendKey(int keyCode, int times)
    {
        IntStream.range(0, times).forEach(i -> sendKey(keyCode));
    }
}
