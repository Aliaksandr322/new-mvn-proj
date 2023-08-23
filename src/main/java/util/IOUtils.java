package util;

import java.io.*;
import java.util.Date;
import java.util.Locale;

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

    public static String readFile(String path){
        StringBuilder sb = new StringBuilder(214748364);
        try (Reader reader = new BufferedReader(new FileReader(path), 214748364)){
            // используем try with resources . See AutoClosable так как reader AutoClosable он будет закрывать stream
            int charcounterCode;
            while ((charcounterCode = reader.read()) != -1){
                sb.append((char)charcounterCode);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check your file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();

    }


    public static String readFileByLines(String path){
        StringBuilder sb = new StringBuilder(214748364);
        try (BufferedReader reader = new BufferedReader(new FileReader(path), 214748364)){
            // используем try with resources . See AutoClosable так как reader AutoClosable он будет закрывать stream
            String line;

            while ((line = reader.readLine()) != null){
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check your file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();

    }


    public static void write(String data, String path, boolean append){
        try (Writer writer = new BufferedWriter(new FileWriter(path , append))){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String data, String path){
        write(data,path,false);

    }

    public static void createCopyFile(String dstPath,String ... paths){
        StringBuilder sb = new StringBuilder();
        for (String path : paths){
            sb.append(readFile(path));
        }
        write(sb.toString(),dstPath);
    }

    public static void copyFiles(String dstPath ,String path1, String path2){
        String content1 = readFile(path1);
        String content2 = readFile(path2);
        write(content1 + content2 , dstPath);

    }

    public static void findWord(String filePath, String searchText){
        String content = readFile(filePath);
        if(content.toLowerCase().contains(searchText.toLowerCase())){
            System.out.println("Search text is found");
        }else {
            System.out.println("Search text is not found");
        }
    }


    public static void main(String[] args) {

        try (Resource res = new Resource()){
            //working with resources
            res.addLine("Hello");
            res.addLine("world");
            res.printDate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

class  Resource implements Closeable{

    private String data = new String();

    @Override
    public void close() throws IOException {
        if(data.length() > 0){
            System.out.println("Resource data clear");
            data = new String();
        }
    }

    public void addLine(String line){
        data +=line;
    }
    public void printDate(){
        System.out.println(data);
    }
}

class Tasks{
    public static void main(String[] args) {
        t1("D:\\io_tests\\tasks\\task#1.txt", "D:\\io_tests\\tasks\\task#2.txt");
        t2("D:\\io_tests\\tasks\\task#3.txt", "D:\\io_tests\\tasks\\count_result.txt", "JAva");
        t2("D:\\io_tests\\tasks\\task#3.txt", "D:\\io_tests\\tasks\\count_result.txt", new String("Java"));
    }

    public static void t1(String path , String resultPath){
        System.out.println("---------Task #1 Revers file text---------");
        //1 step : read content
        String data = IOUtils.readFileByLines(path);
        //2 step : process String value (reverce)
        String result = new StringBuilder(data).reverse().toString();
        //3 step : write result file
        IOUtils.write(result,resultPath);

    }
    public static void t2(String filePath , String resultPath, String search){

        int counter = 0;
        String resultFormat = "\"%s\" : %d";
        String data = IOUtils.readFileByLines(filePath).toLowerCase();
        search = search.toLowerCase();
        if (!data.toLowerCase().contains(search.toLowerCase())){
            IOUtils.write(String.format(resultFormat,search,counter),resultPath);

        }
        else {
//            String array[] = data.split(" ");
//            for (int i = 0; i < array.length; i++) {
//                if (array[i].equals(search.toLowerCase())) {
//                    counter++;
//                }
//            }

            int index ;
            while ((index = data.indexOf(search)) != -1){
                counter++;
                data = data.substring(index + search.length());
            }
            IOUtils.write(String.format(resultFormat,search,counter),resultPath);
        }
    }

//    public static void t2(String filePath , String resultPath, String... searchs){
//
//        //for each по массиву слов и дописывать в него
//        for(String search : searchs) {
//            int counter = 0;
//            String resultFormat = "\"%s\" : %d";
//            String data = IOUtils.readFileByLines(filePath).toLowerCase();
//
//            if (!data.toLowerCase().contains(search.toLowerCase())){
//                IOUtils.write(String.format(resultFormat,search,counter),resultPath);
//                return;
//            }
//            else {
//                String array[] = data.split(" ");
//                for (int i = 0; i < array.length; i++) {
//                    if (array[i].equals(search.toLowerCase())) {
//                        counter++;
//                    }
//                }
//            }
//            IOUtils.write(Integer.toString(counter), resultPath,true);
//        }
//    }
}

//   public static void t2(String filePath, String resultFilePath, String search){
//        // <search word> : <counter>
//        String resultFormat = "\"%s\" : %d";
//        // example : "Java" : 14  (ignoring register) , "JAVA"
//        //1 step: read content
//        String data = IOUtils.readFile(filePath).toLowerCase();
//        search = search.toLowerCase();
//
//        int counter = 0;
//        //2 walk and count words in <search word> : <counter> format
//        if(data.contains(search)){
//
//            int index;
//            while ((index = data.indexOf(search)) != -1){
//                counter++;
//                data = data.substring(index + search.length());
//            }
//
//        }
//
//        //3 save the results
//        IOUtils.write(String.format(resultFormat, search, counter), resultFilePath);
//
//
//
//    }