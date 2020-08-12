package com.home.selenide2.common.autoit;

import com.home.selenide2.common.utils.FileUtils;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class AutoItUtils
{
    private static final String COMPILER_FILE_PATH = FileUtils.getResourcePath(String.join(File.separator, "autoit", "Aut2Exe", "Aut2exe.exe"));

    @SneakyThrows
    public static void execute(String scriptPathOffsetWithoutExt)
    {
        var scriptFolderRelativeToResourceFolder = String.join(File.separator, "autoit", "scripts", scriptPathOffsetWithoutExt);
        var scriptFolderAbsolute = FileUtils.getResourcePath(scriptFolderRelativeToResourceFolder);
        var auFilePath = scriptFolderAbsolute + ".au3";
        var exeFilePath = scriptFolderAbsolute + ".exe";
        executeCommand(COMPILER_FILE_PATH, "/in", auFilePath);
        executeCommand(exeFilePath);
    }

    private static void executeCommand(String... args) throws IOException, InterruptedException
    {
        new ProcessBuilder().command(args).start().waitFor();
    }
}
