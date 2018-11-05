package com.file;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by simpletour_Jenkin on 2016/11/3.
 */
public class findFiles {

    public static void main(String[] args) {
        String path = "D:/我的项目";
        File f = new File(path);
        for (File temp : f.listFiles()){
            if (temp.isFile()){
                System.out.println(temp.getName());
            }else {
                System.out.println(temp.getPath());
            }
        }

        findFile(path);

    }

    public static void findFile(String path){
        File f = new File(path);
        for (File temp : f.listFiles()){
            if (temp.isFile()){
                System.out.println(temp.getName());
            }else {
                findFile(temp.getPath());
            }
        }
    }
}
