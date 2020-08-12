package com.home.selenide2.cucumber.heroku;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.home.selenide2.common.beans.RestTemplateSilent;
import com.home.selenide2.cucumber.heroku.glue.pages.TablesPage;
import com.home.selenide2.cucumber.heroku.glue.pages.TinymcePage;
import com.home.selenide2.cucumber.heroku.glue.pages.TyposPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(tags = ""
        ,plugin = "pretty"
        ,glue = { "com.home.selenide2.cucumber.heroku", "com.home.selenide2.cucumber.common" }
)
@SpringBootTest(classes = { TablesPage.class, TyposPage.class, TinymcePage.class, RestTemplateSilent.class })
@ExtendWith(ScreenShooterExtension.class)
public class Test
{

}
