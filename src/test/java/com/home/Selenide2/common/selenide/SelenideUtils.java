package com.home.Selenide2.common.selenide;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Selenide;
import com.home.Selenide2.common.selenide.actions.BringToFront;

import javax.annotation.ParametersAreNonnullByDefault;
import java.net.URL;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.home.Selenide2.common.OperandUtils.with;
import static com.home.Selenide2.common.selenide.actions.InBrowsersAction.inBrowserAction;

@ParametersAreNonnullByDefault
public class SelenideUtils extends Selenide
{
    public static void open(URL absoluteUrl)
    {
        open();
        openExt();
    }

    public static <PageObjectClass> PageObjectClass open(String relativeOrAbsoluteUrl, Class<PageObjectClass> pageObjectClassClass)
    {
        return with(Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass)).execute(SelenideUtils::openExt);
    }

    public static void open(String relativeOrAbsoluteUrl, AuthenticationType authenticationType, String login, String password)
    {
        open(relativeOrAbsoluteUrl, authenticationType, login, password);
        openExt();
    }

    private static void openExt()
    {
        openExt(null);
    }

    private static <T> T openExt(T val)
    {
        inBrowserAction(FIREFOX).add(BringToFront::new).execute();
        inBrowserAction(CHROME).add(BringToFront::new).execute();
        return val;
    }


}
