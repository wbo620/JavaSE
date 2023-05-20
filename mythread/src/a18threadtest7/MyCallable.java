package a18threadtest7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {

        int price=0;

        ArrayList<Integer> boxlist = new ArrayList<Integer>();
        while (true) {
            synchronized (MyCallable.class) {

                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName()+boxlist);

                    int sum = getSum(boxlist);
                    System.out.println(Thread.currentThread().getName()+"抽到的和为"+sum+"元");

                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    price = list.remove(0);
                    boxlist.add(price);
                }
            }
            Thread.sleep(10);

        }
        if (boxlist.size() == 0) {
            return 0;
        }else {
            return Collections.max(boxlist);
        }

    }


    public static   int getSum(ArrayList<Integer> list) {
        int sum=0;
        for (Integer i : list) {
            sum+=i;
        }
        return sum;
    }

}
