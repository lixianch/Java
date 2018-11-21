package concurrency;

import java.util.concurrent.Exchanger;

/**
 * Created by lixianch on 2018/10/15.
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");

        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }


}

class ExchangerRunnable implements Runnable {
    private Exchanger<String> exchanger;
    private String field;
    public ExchangerRunnable(Exchanger<String> exchanger,String field){
        this.exchanger = exchanger;
        this.field = field;
    }


    @Override
    public void run() {
        try {
            Object previous = this.field;

            this.field = this.exchanger.exchange(this.field);

            System.out.println(
                    Thread.currentThread().getName() + " exchanged " + previous + " for " + this.field
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
