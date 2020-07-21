package com.home.Selenide2.runcucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
//@CucumberOptions(tags = "",
//        features =
//                {
//                        "src/test/resources"
//                },
//        plugin =
//                {
//                        "pretty",
//                        "html:target/cucumber.html"
//                })
@CucumberContextConfiguration
@SpringBootTest
public class RunCucumberTest
{

}

