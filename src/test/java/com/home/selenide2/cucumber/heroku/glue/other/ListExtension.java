package com.home.selenide2.cucumber.heroku.glue.other;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListExtension
{
    public <T, U extends Comparable<U>> List<T> sortByField(List<T> list, Function<T, U> mapper, boolean asc)
    {
        var comparator = getComparator(mapper, asc);
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private <T, U extends Comparable<U>> Comparator<T> getComparator(Function<T, U> mapper, boolean asc)
    {
        var comparator = Comparator.comparing(mapper);
        if (!asc)
        {
            comparator = comparator.reversed();
        }
        return comparator;
    }
}
