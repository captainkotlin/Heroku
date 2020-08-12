package com.home.selenide2.common.selenide;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Selenide;
import com.home.selenide2.common.selenide.actions.BringToFront;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.home.selenide2.common.selenide.actions.InBrowsersAction.inBrowsersAction;
import static com.home.selenide2.common.utils.OperandUtils.with;

@ParametersAreNonnullByDefault
public class SelenideUtils extends Selenide
{
    public static void open(String absoluteUrl)
    {
        Selenide.open(absoluteUrl);
        openExt();
    }

    @Nonnull
    public static <PageObjectClass> PageObjectClass open(String relativeOrAbsoluteUrl, Class<PageObjectClass> pageObjectClassClass)
    {
        return with(Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass)).execute(SelenideUtils::openExt);
    }

    public static void open(String relativeOrAbsoluteUrl, AuthenticationType authenticationType, String login, String password)
    {
        Selenide.open(relativeOrAbsoluteUrl, authenticationType, login, password);
        openExt();
    }

    private static void openExt()
    {
        openExt(null);
    }

    private static <T> T openExt(T val)
    {
        inBrowsersAction(FIREFOX).add(BringToFront::new).execute();
        inBrowsersAction(CHROME).add(BringToFront::new).execute();
        return val;
    }


}
