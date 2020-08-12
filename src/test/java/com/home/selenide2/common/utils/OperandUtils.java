package com.home.selenide2.common.utils;

import java.util.function.Function;

public class OperandUtils<T>
{
    private T val;

    private OperandUtils(T val)
    {
        this.val = val;
    }

    public static <T> OperandUtils<T> with(T t)
    {
        return new OperandUtils<>(t);
    }

    public T execute(Function<T, T> func)
    {
        return func.apply(val);
    }
}
