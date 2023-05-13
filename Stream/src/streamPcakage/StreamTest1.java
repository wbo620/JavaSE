package streamPcakage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    //练习:添加一些数据,将奇数添加到新的结合中
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);

        List<Integer> list1 = list.stream().filter(s -> s % 2 == 1).collect(Collectors.toList());
        System.out.println(list1);
    }
}
