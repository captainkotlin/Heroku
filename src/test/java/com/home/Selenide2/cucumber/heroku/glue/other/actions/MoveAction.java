package com.home.Selenide2.cucumber.heroku.glue.other.actions;

import com.home.Selenide2.common.RobotWrapper;
import lombok.SneakyThrows;
import org.openqa.selenium.interactions.Action;

import java.awt.*;
import java.util.function.Function;

public class MoveAction implements Action
{
    private final Point desiredPoint;
    private Point currentPoint;
    private final RobotWrapper robotWrapper;

    public MoveAction(double x, double y)
    {
        robotWrapper = RobotWrapper.build();
        currentPoint = currentMouseCoords();
        desiredPoint = new Point();
        desiredPoint.setLocation(x, y);
    }

    public static MoveAction asMoveX(int x)
    {
        return new MoveAction(x, currentMouseCoords().getY());
    }

    public static MoveAction asMoveY(int y)
    {
        return new MoveAction(currentMouseCoords().getX(), y);
    }

    @Override
    public void perform()
    {
        int addX = addend(Point::getX);
        int addY = addend(Point::getY);
        while (moveShouldContinue(Point::getX) || moveShouldContinue(Point::getY))
        {
            updateCurrentPos(addX, addY);
        }
    }

    private int addend(Function<Point, Double> getter)
    {
        return (int) Math.signum(getter.apply(desiredPoint) - getter.apply(currentPoint));
    }

    private boolean moveShouldContinue(Function<Point, Double> getter)
    {
        return !getter.apply(currentPoint).equals(getter.apply(desiredPoint));
    }

    private void updateCurrentPos(int addX, int addY)
    {
        safeSleep(2);
        double updatedX = currentPoint.getX() + addX;
        double updatedY = currentPoint.getY() + addY;
        robotWrapper.mouseMove((int) updatedX, (int) updatedY);
        currentPoint = new Point();
        currentPoint.setLocation(updatedX, updatedY);
    }

    private static Point currentMouseCoords()
    {
        PointerInfo mouseInfo = MouseInfo.getPointerInfo();
        return mouseInfo.getLocation();
    }

    @SneakyThrows
    private void safeSleep(int millis)
    {
        Thread.sleep(millis);
    }
}
