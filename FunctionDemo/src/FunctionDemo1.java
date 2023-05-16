import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo1 {

    //将集合中的字母大写,并存入新的集合中
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list, "aaa","bbb","ccc");

        List<String> list1 = list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
        System.out.println(list1);
        //
        List<String> list2 = list.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list2);
    }



}
