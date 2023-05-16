import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class FunctionDemo2 {
    public static void main(String[] args) {
        //将集合中的数字,收集到数组中

        ArrayList<Integer> list=new ArrayList<Integer>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);

        //匿名内部类
        Integer[] arr1 = list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(arr1));
        //改写

        Integer[] arr2 = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    }
}
