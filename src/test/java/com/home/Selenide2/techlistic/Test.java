package com.home.Selenide2.techlistic;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/com/home/Selenide2/techlistic",
//glue = { "com.home.Selenide2.techlistic" }
//)
//@CucumberOptions(plugin = "pretty")
@CucumberContextConfiguration
public class Test
{
}
