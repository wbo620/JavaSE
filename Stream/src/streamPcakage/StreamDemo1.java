package streamPcakage;

import java.util.ArrayList;

public class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        list1.add("张三丰");
        list1.add("张无忌");
        list1.add("消炎");
        list1.add("小蛤蟆");
        list1.add("癞皮狗");
        list1.stream().filter(name->name.length()==3).filter(name->name.startsWith("张")).forEach(name-> System.out.println(name));



    }

}
