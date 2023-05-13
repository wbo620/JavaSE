package streamPcakage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreamDemo3 {
    public static void main(String[] args) {
        //skip跳过前几个
        //limit获取前几个
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰","张翠山","张良","王二麻子","谢广坤");
        //获取张强,张三丰,张翠山
        list.stream().limit(6).skip(3).forEach(s -> System.out.println(s));
        list.stream().skip(3).limit(3).forEach(s -> System.out.println(s));
    }
}
