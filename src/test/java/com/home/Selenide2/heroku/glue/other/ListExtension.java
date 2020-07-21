package com.home.Selenide2.heroku.glue.other;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListExtension
{
    public <T, U extends Comparable<U>> List<T> sortByField(List<T> list, Function<T, U> mapper, boolean asc)
    {
        Comparator<T> comparator = getComparator(mapper, asc);
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private <T, U extends Comparable<U>> Comparator<T> getComparator(Function<T, U> mapper, boolean asc)
    {
        Comparator<T> comparator = Comparator.comparing(mapper);
        if (!asc)
        {
            comparator = comparator.reversed();
        }
        return comparator;
    }
}
