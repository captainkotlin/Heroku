package com.home.Selenide2.common.python;

import com.home.Selenide2.common.utils.FileUtils;

import java.io.IOException;

public class ImageParser
{
    private static final String PARSER_SCRIPT = "python/imageparser.py";
    private final String imagePath;

    public ImageParser(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public String parse() throws InterruptedException, IOException
    {
        Process process = new ProcessBuilder()
                .command("python3", FileUtils.getPath(PARSER_SCRIPT), imagePath)
                .start();
        process.waitFor();
        return new String(process.getInputStream().readAllBytes());
    }
}
