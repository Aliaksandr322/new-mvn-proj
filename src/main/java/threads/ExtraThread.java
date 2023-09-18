package threads;

import util.ThreadUtils;

import static util.ThreadUtils.*;


public class ExtraThread extends Thread{



    private boolean isActive = true;
    private int times = 5;

    public ExtraThread(String name){
        setName(name);
    }

    public ExtraThread(String name, int times ){
        this.times = times;
        setName(name);
//        start();
    }


    @Override
    public void run() {
        logBegin();

        for (int i = 0; (i < times) && isActive; i++){
            ThreadUtils.sleep();
            int x = (int)(Math.random() * 1000);
            log("Random value is " + x);
        }

        logFinish();
    }

    public void disable(){
        this.isActive = false;
    }
}
