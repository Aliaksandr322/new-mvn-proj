package threads;

import util.ThreadUtils;
import util.XMLCurrencyParser;

import static util.ThreadUtils.*;

public class DaemonThread extends Thread{
    // Обычно это служба (сервис) "служебный поток"
    public DaemonThread(){
        this.setDaemon(true);
    }

    @Override
    public void run() {
        logBegin();
        for (; true; ){
            String rate = XMLCurrencyParser.getCurrency("840");
            log(rate);
            ThreadUtils.sleep(5);
        }
    }

}
