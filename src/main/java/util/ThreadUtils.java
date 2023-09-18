package util;

import java.util.Date;

public class ThreadUtils {

    public static void logBegin(){
        log("Started");


    }



    public static void logFinish(){
        log("Finished");
    }

    public static void log(Object text){
        Thread th = Thread.currentThread();
        System.out.println(String.format("%s[%s] : [%d] %s [%d]" ,
                text.toString(),
                new Date().toString(), th.getId(),th.getName(),th.getPriority() ));
    }

    public static void sleep(double second){
        try {
            log("Start sleeping");
            Thread.sleep((int)(second*1000));
            log("Finish sleeping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep(){
        sleep((int)(Math.random() * 3));
    }

    public static void runInNewThread(Runnable target){
        new Thread(target).start();
    }
}
