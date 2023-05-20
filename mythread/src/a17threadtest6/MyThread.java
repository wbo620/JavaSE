package a17threadtest6;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    ArrayList<Integer>list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int price=0;
        ArrayList<Integer> boxlist = new ArrayList<Integer>();
        while (true) {
            synchronized (MyThread.class) {

                if (list.size() == 0) {
                    System.out.println(getName()+boxlist);
                    int max = getMax(boxlist);
                    System.out.println(getName()+"抽到的最大值为"+max+"元");
                    int sum = getSum(boxlist);
                    System.out.println(getName()+"抽到的和为"+sum+"元");
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    price = list.remove(0);
                    boxlist.add(price);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int getMax(ArrayList<Integer> list) {
        int max=list.get(0);

        for (Integer i : list) {
            max = i > max ? i : max;

        }
        return max;
    }

    public static   int getSum(ArrayList<Integer> list) {
        int sum=0;
        for (Integer i : list) {
            sum+=i;
        }
        return sum;
    }


}
