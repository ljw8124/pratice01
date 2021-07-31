package org.pratice.ioex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy2 {

    //bad code but FileCopy1보다 훨씬 빠름
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\aaa.jpg");

        Path filePath = file.toPath();

        OutputStream out = new FileOutputStream("C:\\Users\\ljw81\\Desktop\\LeeJoungwoo\\copy.jpg");

        Files.copy(filePath, out);

    }
}
