package com.home.selenide2.common.python;

import com.home.selenide2.common.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class ImageParser
{
    private static final String PYTHON_EXECUTABLE = String.join(File.separator, System.getenv("PYTHON_HOME"), "python.exe");
    private static final String PARSER_SCRIPT = String.join(File.separator, "python", "imageparser.py");
    private final String imagePath;

    public ImageParser(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public String parse() throws InterruptedException, IOException
    {
        Process process = new ProcessBuilder()
                .command(PYTHON_EXECUTABLE, FileUtils.getResourcePath(PARSER_SCRIPT), imagePath)
                .start();
        process.waitFor();
        return new String(process.getInputStream().readAllBytes());
    }
}
