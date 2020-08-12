package com.home.selenide2.junit.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

@Slf4j
public class CustomTestExecutionListener implements TestExecutionListener
{
    private StackWalker stackWalker = StackWalker.getInstance();

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan)
    {
        infoLog("testPlanExecutionStarted");
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan)
    {
        infoLog("testPlanExecutionFinished");
    }

    @Override
    public void dynamicTestRegistered(TestIdentifier testIdentifier)
    {
        infoLog("dynamicTestRegistered, id = %s", testIdentifier);
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason)
    {
        infoLog("executionSkipped, id = %s, reason = %s", testIdentifier.getDisplayName(), reason);
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier)
    {
        infoLog("executionStarted, id = %s", testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult)
    {
        infoLog("executionFinished, id = %s, result = %s", testIdentifier.getDisplayName(), testExecutionResult.getStatus().name());
    }

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry)
    {
        infoLog("reportingEntryPublished, id = %s, entry = %s", testIdentifier.getDisplayName(), entry.getKeyValuePairs());
    }

    private void infoLog(String str, Object... args)
    {
        log.info(String.format(str, args));
    }
}
