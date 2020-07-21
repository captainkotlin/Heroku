package com.home.Selenide2.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class PageExt
{
    public static <T> List<T> readTable(SelenideElement table, Function<String[], T> func)
    {
        return table.findElements(By.xpath(".//tbody/tr")).stream()
                .map(row -> toRowClass($$x(".//td"), func))
                .collect(Collectors.toList());
    }

    private static <T> T toRowClass(ElementsCollection collection, Function<String[], T> func)
    {
        String[] cellsInRow = collection.stream()
                .map(SelenideElement::getText)
                .toArray(String[]::new);
        return func.apply(cellsInRow);
    }
}
