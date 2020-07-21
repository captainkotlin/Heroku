package com.home.Selenide2.heroku.glue.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class TablesPage
{
    private static final String TABLE1_LOCATOR = "#table1";
    private static String TABLE1_HEADER_LOCATOR = ".//thead/tr/th/span[text()='%s']/parent::th";

    public SelenideElement table1()
    {
        return $(TABLE1_LOCATOR);
    }

    public SelenideElement sortTable1ByHeader(String text, boolean asc)
    {
        SelenideElement tableHeader = table1().$x(String.format(Locale.US, TABLE1_HEADER_LOCATOR, text));
        boolean isAsc = !tableHeader.getAttribute("class").contains("headerSortDown");
        if (asc == isAsc)
        {
            tableHeader.click();
        }
        else
        {
            tableHeader.click();
            tableHeader.click();
        }
        return table1();
    }
}
