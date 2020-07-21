package com.home.Selenide2.heroku;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.home.Selenide2.common.beans.RestTemplateSilent;
import com.home.Selenide2.heroku.glue.pages.TablesPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(tags = "@Debug"
        ,plugin = "pretty"
        ,extraGlue = { "com.home.Selenide2.common" }
)
@SpringBootTest(classes = { TablesPage.class, RestTemplateSilent.class })
@ExtendWith(ScreenShooterExtension.class)
public class Test
{

}
