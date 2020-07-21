package com.home.Selenide2.common.utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileUtils
{
    private static String mainPackage = null;

    static
    {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        try
        {
            model = reader.read(new FileReader("pom.xml"));
            mainPackage = packagesToPaths(model.getGroupId(), model.getArtifactId());
        }
        catch (IOException | XmlPullParserException e)
        {
            throw new RuntimeException();
        }
    }

    public static String getPath(String relativeFilePath)
    {
        return Paths.get(FileUtils.class.getClassLoader().getResource("").getFile())
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
