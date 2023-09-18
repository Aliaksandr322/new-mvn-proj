package threads;

import util.ThreadUtils;

import static util.ThreadUtils.*;

public class ExtraTester {
    public static void main(String[] args) throws InterruptedException {
        logBegin();
//        DaemonThread daemon = new DaemonThread();
//        daemon.start();
//        ExtraThread ex = new ExtraThread("Generator",10);
//        ex.start();
//
////        sleep(10);
////        ex.disable();
//        ex.join();

        TaskThread th1 = new TaskThread("Job1");
        new TaskThread(th1,"Job2");


        logFinish();
    }
}
