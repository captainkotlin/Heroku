package com.home.selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

@Component
public class TablesPage
{
    public SelenideElement table1()
    {
        return $("#table1");
    }

    public void sortTable1ByHeader(String text, boolean asc)
    {
        var TABLE1_HEADER_LOCATOR = ".//thead/tr/th/span[text()='%s']/parent::th";
        var tableHeader = table1().$x(String.format(Locale.US, TABLE1_HEADER_LOCATOR, text));
        var isAsc = !Objects.requireNonNull(tableHeader.getAttribute("class")).contains("headerSortDown");
        tableHeader.click();
        if (asc != isAsc)
        {
            tableHeader.click();
        }
        table1();
    }
}
