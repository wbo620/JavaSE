package a08threadsafe2;

public class MyRunnable implements Runnable {
    int ticket=0;
    @Override
    public void run() {
        //1.循环
        while (true){
                if (method()) break;
        }

    }

    private synchronized boolean method() {
        //判断共享数据是否到了末尾,如果到了末尾
        if (ticket==500){
            return true;
        }else {
            //判断共享数据是否到了末尾,如果没到末尾
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在卖第"+": " + ticket+"张票!");
        }
        return false;
    }
}
