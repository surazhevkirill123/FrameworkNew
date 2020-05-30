package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateNewFile {
    public static void createFileWithPathAndText(String sPath,String text) {
        Path path = Paths.get(sPath);
        try {

            byte[] bs = text.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        createFileWithPathAndText("E:\\STUDIES\\PROGA2kurs\\4sem\\IntelijIdea\\Laba9_3\\myDir\\file.txt","Hello dude");

    }

}