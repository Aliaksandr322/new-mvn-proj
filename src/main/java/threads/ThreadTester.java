package threads;

import java.util.Date;

import static util.ThreadUtils.*;

public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
        Thread currentTh = Thread.currentThread();
        currentTh.setName("MAIN");
        logBegin();
        System.out.println("Started[" + new Date() + "]: " + currentTh.getName() + " / Priority: " + currentTh.getPriority());
        currentTh.setPriority(10);

        System.out.println("Starting Child -> ");
        ChildThread ch = new ChildThread();
        ch.setName("CHILD");
        ch.start();// execute run method in parallel thread!

        //start 15 extra Child Thread
//        for (int i = 0 ; i < 15 ; i++){
//            ChildThread child = new ChildThread();
//            child.setName("CHILD EXTRA THREAD #" + i);
//            child.start();
//        }

        ChildThread2 ch2 = new ChildThread2();
        new Thread(ch2).start();
         //Lambda way
        new Thread(()-> {
           log("Lambda parallel Thread");
        });
        // using wraper method
        runInNewThread(() -> {
            log("Lambda parallel Thread");
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                log("Internal class parallel Thread");
            }
        }).start();

        for (int i = 0; i < 5; i++){
            Thread.sleep(500);
            log(i);
        }
        logFinish();
    }
}
