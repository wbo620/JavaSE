package a15threadtest4;

import javax.xml.transform.Source;
import java.util.Random;

public class MyThread extends Thread {

    static double money = 100;
    static int count = 3;
    static final double MIN = 0.01;


    @Override
    public void run() {

        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包");
            } else {
            double price=0;
                if (count == 1) {
                    price=money;
                } else {
                    Random r = new Random();
                    double bounds = money - (count - 1) * MIN;

                    price = r.nextDouble(bounds);
                    if (price < MIN) {
                        price = MIN;
                    }

                }
                System.out.println(getName() + "抢到了" + price + "元");
                money = money - price;
                count--;
            }

        }
    }

}

