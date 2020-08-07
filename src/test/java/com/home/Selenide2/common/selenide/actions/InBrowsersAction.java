package com.home.Selenide2.common.selenide.actions;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class InBrowsersAction
{
    private final String currentBrowser = System.getProperty("selenide.browser");
    private Set<String> browsers;
    private List<Function<String, AbstractAction<?>>> functions = new ArrayList<>();

    public InBrowsersAction(String... browsers)
    {
        this.browsers = Sets.newHashSet(browsers);
    }

    public static InBrowsersAction inBrowserAction(String... browsers)
    {
        return new InBrowsersAction(browsers);
    }

    @SafeVarargs
    public final InBrowsersAction add(Function<String, AbstractAction<?>>... func)
    {
        functions.addAll(Arrays.asList(func));
        return this;
    }

    public <T> T execute()
    {
        if (browsers.contains(currentBrowser))
        {
            int lastElementIndex = functions.size() - 1;
            for (int i = 0; i < lastElementIndex; i++)
            {
                functions.get(i).apply(currentBrowser).perform();
            }
            return (T) functions.get(lastElementIndex).apply(currentBrowser).perform();
        }
        return null;
    }
}
