package streamPcakage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        HashMap<Integer,String> hm=new HashMap<>();
        hm.put(1,"aaa");
        hm.put(2,"bbb");
        hm.put(3,"ccc");
        //把双列集合变成单列结合在进行stream流的操作
        hm.keySet().stream().forEach(s-> System.out.println(s));
        System.out.println("--------------------------------");

        hm.entrySet().stream().forEach(s-> System.out.println(s));
        System.out.println("--------------------------------");
        //零散数据
        Stream.of("a", "b", "c").forEach(s-> System.out.println(s));
        System.out.println("--------------------------------");

        //数组
        int []arr=new int[]{1,2,3};
        String[]arr2={"a", "b", "c", "d"};
        Arrays.stream(arr).forEach(s-> System.out.println(s));
       Arrays.stream(arr2).forEach(s-> System.out.println(s));
    }
}
