package util;

import java.io.File;
import java.util.Date;

public class IOUtils {

    public static void printStat(String path){
        File rootFile = new File(path);

        if (!rootFile.exists()){
            System.out.println("Invalid file path");
            return;
        }

        if (rootFile.isDirectory()){
            System.out.println(String.format("FOLDER <%s><lastModified:%s>" ,
                    rootFile.getName(),new Date(rootFile.lastModified())));
            File[] files = rootFile.listFiles();
            if(files != null) {
                for (File file : files) {
                    printStat(file.getPath());

                }
            }
        }else {
            //it should be file
            System.out.println(String.format("         File <%s><Size:%d>" , rootFile.getName(),rootFile.length()));
        }

    }



}
