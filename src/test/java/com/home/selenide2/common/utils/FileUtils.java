package com.home.selenide2.common.utils;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Paths;

public class FileUtils
{
    private static final String ROOT_PROJECT_FOLDER = System.getProperty("user.dir");
    private static final String RESOURCE_FOLDER = String.join(File.separator, ROOT_PROJECT_FOLDER,
            "build",
            "resources",
            "test",
            "com", "home", "selenide2");

    @SneakyThrows
    public static String getProjectPath(String relativeFilePath)
    {
        return Paths.get(ROOT_PROJECT_FOLDER)
                .resolve(relativeFilePath)
                .toString();
    }
    @SneakyThrows
    public static String getResourcePath(String relativeFilePath)
    {
        return Paths.get(RESOURCE_FOLDER)
                .resolve(relativeFilePath)
                .toString();
    }
}
