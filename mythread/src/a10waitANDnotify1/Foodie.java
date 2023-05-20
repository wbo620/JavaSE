package a10waitANDnotify1;

public class Foodie extends Thread {
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if (Desk.count==0) {
                    break;
                }else {
                    //先判断桌子上是否有面条
                    if(Desk.foodflag==0) {
                        //有,就等待
                        try {
                            Desk.lock.wait();//让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        //总数-1
                        Desk.count--;
                        //开吃
                        System.out.println("吃货吃了一碗,还能吃"+Desk.count+"碗面条");
                        //唤醒厨师继续做
                        Desk.lock.notifyAll();
                        //修改桌子状态
                        Desk.foodflag=0;
                    }
                }
            }
        }
    }
}
