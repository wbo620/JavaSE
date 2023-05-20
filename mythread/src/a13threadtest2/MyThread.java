package a13threadtest2;

public class MyThread extends Thread{

    static  int count=100;
    @Override
    public void run() {
       while (true) {
           synchronized (MyThread.class){
               if (count<=10){
                   break;
               }else {
                   count--;
                   System.out.println(getName()+"发放了第"+(100-count)+"件礼物,剩余"+count+"件礼物");
               }

           }
       }
    }
}
