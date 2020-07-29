package com.home.Selenide2.cucumber.heroku.glue.entities;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Map;

@Data
@AllArgsConstructor
public class Table1Content
{
    public static final String LAST_NAME = "Last Name";
    public static final String FIRST_NAME = "First Name";
    public static final String EMAIL = "Email";
    public static final String DUE = "Due";
    public static final String WEB_SITE = "Web Site";

    public static Map<String, Comparator<Table1Content>> COMPARATORS_BY_SORT_TYPES = ImmutableMap.<String, Comparator<Table1Content>>builder()
            .put(LAST_NAME, Comparator.comparing(Table1Content::getLastname))
            .put(FIRST_NAME, Comparator.comparing(Table1Content::getFirstname))
            .put(EMAIL, Comparator.comparing(Table1Content::getEmail))
            .put(DUE, Comparator.comparing(Table1Content::getDue))
            .put(WEB_SITE, Comparator.comparing(Table1Content::getWebsite))
            .build();

    private String lastname;
    private String firstname;
    private String email;
    private String due;
    private String website;



    public Table1Content(String... arr)
    {
        int i = 0;
        lastname = arr[i++];
        firstname = arr[i++];
        email = arr[i++];
        due = arr[i++];
        website = arr[i];
    }
}
