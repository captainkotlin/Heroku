package com.home.Selenide2.cucumber.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

@Component
public class TablesPage
{
    private static final String TABLE1_LOCATOR = "#table1";

    public SelenideElement table1()
    {
        return $(TABLE1_LOCATOR);
    }

    public void sortTable1ByHeader(String text, boolean asc)
    {
        String TABLE1_HEADER_LOCATOR = ".//thead/tr/th/span[text()='%s']/parent::th";
        SelenideElement tableHeader = table1().$x(String.format(Locale.US, TABLE1_HEADER_LOCATOR, text));
        boolean isAsc = !Objects.requireNonNull(tableHeader.getAttribute("class")).contains("headerSortDown");
        tableHeader.click();
        if (asc != isAsc)
        {
            tableHeader.click();
        }
        table1();
    }
}
