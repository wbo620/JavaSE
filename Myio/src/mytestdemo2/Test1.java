package mytestdemo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
        * 随机点名器1（学生独立完成）
        需求：
           有一个文件里面存储了班级同学的信息，每一个信息占一行。
          格式为：张三-男-23
          要求通过程序实现随机点名器。
        运行效果：
             第一次运行程序：随机同学姓名1（只显示名字）
             第二次运行程序：随机同学姓名2（只显示名字）
             第三次运行程序：随机同学姓名3（只显示名字）*/

        //关联要读取的文件
        BufferedReader br = new BufferedReader(new FileReader("src/随机姓名.txt"));
        //创建一个集合存放读取的数据
        ArrayList<String> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        //打乱集合
        Collections.shuffle(list);
        //获取打乱后的第一个
        String s = list.get(0);
        //切割字符串,只留下姓名
        System.out.println(s.split("-")[0]);


    }
}
