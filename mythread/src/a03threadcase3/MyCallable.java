package a03threadcase3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    //0-100的和
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
