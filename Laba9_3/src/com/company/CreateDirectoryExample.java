package com.company;

import java.io.File;

public class CreateDirectoryExample {
    public static void createDirectory(String path){
        File theDir = new File(path);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
        else {
            System.out.println("Dir already exists");
        }
    }
    public static void main(String[] args) {
        createDirectory("E:\\STUDIES\\PROGA2kurs\\4sem\\IntelijIdea\\Laba9_3\\myDir");
    }
}
