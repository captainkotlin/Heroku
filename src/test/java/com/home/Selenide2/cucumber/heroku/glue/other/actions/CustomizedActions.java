package com.home.Selenide2.cucumber.heroku.glue.other.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class CustomizedActions extends Actions
{
    private final WebDriver driver;
    private AbstractWebDriverEventListener eventListener;

    public CustomizedActions(WebDriver driver)
    {
        super(new EventFiringKeyboard(driver, null), new EventFiringMouse(driver, null));
        this.driver = driver;
    }

    public CustomizedActions(WebDriver driver, AbstractWebDriverEventListener eventListener)
    {
        super(new EventFiringKeyboard(driver, eventListener), new EventFiringMouse(driver, eventListener));
        this.driver = driver;
        this.eventListener = eventListener;
    }

    public CustomizedActions moveMouseXY(int x, int y)
    {
        return withExceptionHandling(() -> new MoveAction(x, y));
    }

    public CustomizedActions moveMouseX(int x)
    {
        return withExceptionHandling(() -> MoveAction.asMoveX(x));
    }

    public CustomizedActions moveMouseY(int y)
    {
        return withExceptionHandling(() -> MoveAction.asMoveY(y));
    }

    private CustomizedActions withExceptionHandling(ThrowableSupplier<Action> throwableSupplier)
    {
        try
        {
            Action a = throwableSupplier.get();
            action.addAction(a);
        }
        catch (Exception e)
        {
            if (eventListener != null)
            {
                eventListener.onException(e, driver);
            }
        }
        return this;
    }

    @FunctionalInterface
    private interface ThrowableSupplier<T>
    {
        T get() throws Exception;
    }
}
