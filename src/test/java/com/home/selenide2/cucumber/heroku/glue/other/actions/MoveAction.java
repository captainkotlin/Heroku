package com.home.selenide2.cucumber.heroku.glue.other.actions;

import com.home.selenide2.common.robot.RobotUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.interactions.Action;

import java.awt.*;
import java.util.function.Function;

public class MoveAction implements Action
{
    private final Point desiredPoint;
    private Point currentPoint;
    private final RobotUtils robotWrapper;

    public MoveAction(double x, double y)
    {
        robotWrapper = RobotUtils.build();
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
        var addX = addend(Point::getX);
        var addY = addend(Point::getY);
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
        safeSleep();
        var updatedX = currentPoint.getX() + addX;
        var updatedY = currentPoint.getY() + addY;
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
    private void safeSleep()
    {
        Thread.sleep(2);
    }
}
