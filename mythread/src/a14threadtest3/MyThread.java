package a14threadtest3;

public class MyThread extends Thread{
   /* 同时开启两个线程，共同获取1-100之间的所有数字。
    要求：将输出所有的奇数。*/
    static  int num=1;

    @Override
    public void run() {
      while (true){
          synchronized (MyThread.class){
              if (num>=100){
                  break;
              }else {

                  System.out.println(getName()+":"+num);
                  num+=2;
              }
          }
      }
    }
}
