package com.home.selenide2.common.selenide.controls;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class InBrowserControl<T>
{
    private final String currentBrowser = System.getProperty("selenide.browser");
    private SelenideElement selenideElement;
    private Map<String, Function<SelenideElement, T>> controlsByBrowsers = new HashMap<>();

    public InBrowserControl(SelenideElement selenideElement)
    {
        this.selenideElement = selenideElement;
    }

    public static <T> InBrowserControl<T> inBrowserControl(SelenideElement selenideElement)
    {
        return new InBrowserControl<T>(selenideElement);
    }

    public InBrowserControl<T> add(String browser, Function<SelenideElement, T> supplier)
    {
        controlsByBrowsers.put(browser, supplier);
        return this;
    }

    public T get()
    {
        return controlsByBrowsers.getOrDefault(currentBrowser, (str) -> null).apply(selenideElement);
    }
}
