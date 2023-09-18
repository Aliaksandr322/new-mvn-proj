package threads;

import lombok.SneakyThrows;
import util.ThreadUtils;

public class TaskThread extends Thread{
    //wait this thread
    private Thread joinTo;
    private String job;

    public TaskThread(Thread joinTo, String job){
        this.joinTo = joinTo;
        this.job = job;
    }

    public TaskThread(String job){
        this.job = job;
    }

    @SneakyThrows
    @Override
    public void run(){
        ThreadUtils.logBegin();
        if(joinTo != null && joinTo.isAlive() && joinTo.isDaemon()){
            // wait for
            ThreadUtils.log("Start waiting " + joinTo.getId());
            joinTo.join();
        }
        ThreadUtils.log("Working with " + job);
        ThreadUtils.sleep();

        ThreadUtils.logFinish();
    }



}
