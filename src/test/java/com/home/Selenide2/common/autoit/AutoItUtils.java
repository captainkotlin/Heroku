package com.home.Selenide2.common.autoit;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class AutoItUtils
{
    private static final String COMPILER_FILE_PATH = ".\\build\\resources\\test\\com\\home\\Selenide2\\autoit\\Aut2Exe\\Aut2exe.exe";
    private static final String SCRIPT_FOLDER_ROOT_PATH = ".\\build\\resources\\test\\com\\home\\Selenide2\\autoit\\scripts";

    @SneakyThrows
    public static void execute(String scriptPathOffsetWithoutExt)
    {
        String scriptFolder = SCRIPT_FOLDER_ROOT_PATH + File.separator + scriptPathOffsetWithoutExt;
        String auFilePath = scriptFolder + ".au3";
        String exeFilePath = scriptFolder + ".exe";
        executeCommand(COMPILER_FILE_PATH, "/in", auFilePath);
        executeCommand(exeFilePath);
    }

    private static void executeCommand(String... args) throws IOException, InterruptedException
    {
        new ProcessBuilder().command(args).start().waitFor();
    }
}
