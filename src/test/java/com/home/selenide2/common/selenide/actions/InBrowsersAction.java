package com.home.selenide2.common.selenide.actions;

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
    private List<Function<String, ?>> functions = new ArrayList<>();

    public InBrowsersAction(String... browsers)
    {
        this.browsers = Sets.newHashSet(browsers);
    }

    public static InBrowsersAction inBrowsersAction(String... browsers)
    {
        return new InBrowsersAction(browsers);
    }

    @SafeVarargs
    public final InBrowsersAction add(Function<String, ?>... func)
    {
        functions.addAll(Arrays.asList(func));
        return this;
    }

    public <T> T execute()
    {
        if (browsers.contains(currentBrowser))
        {
            var lastElementIndex = functions.size() - 1;
            for (var i = 0; i < lastElementIndex; i++)
            {
                executeAction(i);
            }
            // Arguable, comes from assumption that return type of all entries in 'functions' is same
            return executeAction(lastElementIndex);
        }
        return null;
    }

    private <T> T executeAction(int i)
    {
        Object result = functions.get(i).apply(currentBrowser);
        if (result instanceof AbstractAction)
        {
            result = ((AbstractAction<?>) result).perform();
        }
        return (T) result;
    }
}
