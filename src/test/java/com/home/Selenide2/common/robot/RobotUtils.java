package com.home.Selenide2.common.robot;

import lombok.SneakyThrows;
import lombok.Synchronized;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RobotUtils extends Robot
{
    static
    {
        System.setProperty("java.awt.headless", "false");
    }

    private static RobotUtils robotWrapper;

    @Synchronized
    @SneakyThrows
    public static RobotUtils build()
    {
        if (robotWrapper == null)
        {
            try
            {
                robotWrapper = new RobotUtils();
            }
            catch (AWTException e)
            {
                throw new RuntimeException();
            }
        }
        return robotWrapper;
    }

    private RobotUtils() throws AWTException
    {
        super();
    }

    public void sendKey(String key)
    {
        key.chars().forEach(keyCode ->
        {
            keyPress(keyCode);
            keyRelease(keyCode);
        });
    }

    public void sendKey(int keyCode)
    {
        keyPress(keyCode);
        keyRelease(keyCode);
    }

    public void sendKeyWithModifiers(int keyCode, int... modifiers)
    {
        Arrays.stream(modifiers).forEach(this::keyPress);
        keyPress(keyCode);
        keyRelease(keyCode);
        Arrays.stream(modifiers).forEach(this::keyRelease);
    }

    public void sendKey(int keyCode, int times)
    {
        IntStream.range(0, times).forEach(i -> sendKey(keyCode));
    }
}
