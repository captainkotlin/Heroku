package com.home.selenide2.cucumber.heroku.glue.features;

import com.home.selenide2.cucumber.common.PageExt;
import com.home.selenide2.cucumber.heroku.glue.entities.Table1Content;
import com.home.selenide2.cucumber.heroku.glue.pages.TablesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Tables
{
    @Autowired
    private TablesPage page;
    Comparator<Table1Content> comparator;
    List<Table1Content> expectedContentList;
    List<Table1Content> actualContentList;

    @When("^Button with (.*) and ascending status (.*) is pressed$")
    public void buttonWithSortTypeAndAscendingStatusAscIsPressed(String sortType, Boolean asc)
    {
        comparator = Table1Content.COMPARATORS_BY_SORT_TYPES.get(sortType);
        assertNotNull(comparator);
        if (!asc)
        {
            comparator = comparator.reversed();
        }
        page.sortTable1ByHeader(sortType, asc);
    }

    @Then("table{int} is sorted correctly")
    public void tableIsSortedCorrectly(int tableIndex)
    {
        var table = page.table1();
        expectedContentList = PageExt.readTable(table, Table1Content::new);
        actualContentList = expectedContentList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        assertEquals(expectedContentList, actualContentList);
    }
}
