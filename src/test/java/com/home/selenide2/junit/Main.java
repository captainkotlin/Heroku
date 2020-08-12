package com.home.selenide2.junit;

import com.home.selenide2.junit.common.CustomTestExecutionListener;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class Main
{
    public static void main(String[] args)
    {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("com.home.selenide2"))
                .filters(includeClassNamePatterns(".*"))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        TestExecutionListener listener = new CustomTestExecutionListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
}
