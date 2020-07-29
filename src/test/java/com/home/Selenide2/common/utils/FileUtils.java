package com.home.Selenide2.common.utils;

import lombok.SneakyThrows;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileUtils
{
    private static final String mainPackage;

    static
    {
        mainPackage = initMainPackage();
    }

    @SneakyThrows
    private static String initMainPackage()
    {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        return packagesToPaths(model.getGroupId(), model.getArtifactId());
    }

    public static String getPath(String relativeFilePath)
    {
        return Paths.get(Objects.requireNonNull(FileUtils.class.getClassLoader().getResource("")).getFile())
                .resolve(FileUtils.mainPackage)
                .resolve(relativeFilePath)
                .toString();
    }

    private static String packagesToPaths(String... packages)
    {
        return Arrays.stream(packages)
                .map(p -> p.replace('.', File.separatorChar))
                .collect(Collectors.joining(File.separator));
    }
}
