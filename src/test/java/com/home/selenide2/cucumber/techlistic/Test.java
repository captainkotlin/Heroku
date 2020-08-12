package com.home.selenide2.cucumber.techlistic;

import com.home.selenide2.cucumber.techlistic.glue.background.Page;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.home.selenide2.cucumber.techlistic", "com.home.selenide2.cucumber.common" })
@CucumberContextConfiguration
@SpringBootTest(classes = Page.class)
public class Test
{
}
