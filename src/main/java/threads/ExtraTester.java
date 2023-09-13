package threads;

import static util.ThreadUtils.*;

public class ExtraTester {
    public static void main(String[] args) throws InterruptedException {
        logBegin();
        ExtraThread ex = new ExtraThread("Generator",10);
        ex.start();

//        sleep(10);
//        ex.disable();
        ex.join(2000);
        logFinish();
    }
}
