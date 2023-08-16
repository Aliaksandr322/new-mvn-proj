package io;

import lombok.Data;
import util.IOUtils;

import java.io.*;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        File file = new File("D:\\io_tests\\new_file.txt");

        try {
            boolean isCreated = file.createNewFile();
            System.out.println("New file is created - "  + isCreated);



            File file2 = new File("D:\\io_tests\\simple_file2.txt");
            boolean isExist = file2.exists();
            if (!isExist){
                file2.createNewFile();
                System.out.println("New file is created ");
            }

            File file3 = new File("D:\\io_tests");
            System.out.println("Path : " + file3.getPath());
            System.out.println("Name : " + file3.getName());
            File files[] = file3.listFiles();
            System.out.println("Pathnames size : " + files.length);

            System.out.println("******************");
//            IOUtils.printStat("C:\\Windows");

            InputStream is = new FileInputStream(new File("D:\\io_tests\\war_and_peace.txt"));
            int code = is.read();
            System.out.println("Code = " + code);
            char ch = (char) code;
            Date startDate0 = new Date();
            while ((code = is.read()) != -1){
                System.out.print((char)code);
            }
            Date endDate0 = new Date();
            long miles0 = endDate0.getTime() - startDate0.getTime();


            System.out.println("-----------------");
            Reader reader = new FileReader("D:\\io_tests\\war_and_peace.txt");

            int characterCode;
            while ((characterCode = reader.read()) != -1){
                System.out.print((char)characterCode);
            }


            Reader reader1 = new BufferedReader(new FileReader("D:\\io_tests\\war_and_peace.txt"));
            reader1.read();
            Date startDate = new Date();
            int characterCode2;
            while ((characterCode2 = reader1.read()) != -1){
                System.out.print((char)characterCode2);
            }
            Date endDate = new Date();
            long miles = endDate.getTime() - startDate.getTime();
            System.out.println("Processing took " + miles);
            System.out.println("Processing took " + miles0);

        } catch (IOException e) {
            e.printStackTrace();

        }



    }




}
