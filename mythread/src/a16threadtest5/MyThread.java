package a16threadtest5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class MyThread extends Thread {

    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        /*
        * 1.循环
        * 2.同步代码块
        * 3.判断,是否到末尾
        * 4.判断,没到末尾
        * */

      while (true) {
            synchronized (MyThread.class) {

                if (list.size()==0){
                    break;
                }else {
                    //继续抽奖
                    Collections.shuffle(list);
                    System.out.println(getName() + "又产生了一个" + list.get(0) + "的大奖");
                    list.remove(0);
                }
            }
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
        }
    }


}
