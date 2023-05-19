package mytestdemo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test3 {
    public static void main(String[] args) throws IOException {
        /*随机点名器3（学生独立完成）
            需求：
                 一个文件里面存储了班级同学的姓名，每一个姓名占一行。
                  要求通过程序实现随机点名器。
                 第三次必定是张三同学
            运行效果：
                 第一次运行程序：随机同学姓名1
                 第二次运行程序：随机同学姓名2
                 第三次运行程序：张三*/

        //1.连接到文件
        BufferedReader br1 = new BufferedReader(new FileReader("src/随机姓名.txt"));
        //2.创建一个记录访问次数的文件,并把初始值设置为0
        BufferedReader br2 = new BufferedReader(new FileReader("src/count.txt"));
        //3.读取记录次数的文件
        String countStr = br2.readLine();
        System.out.println(countStr);
        //关流
        br2.close();
        int count = Integer.parseInt(countStr);
        if (count<3) {
            //4.创建写入缓冲流,为了改写记录次数的文件
            BufferedWriter bw=new BufferedWriter(new FileWriter("src/count.txt"));
            //创建一个集合存放读取的数据
            ArrayList<String> list = new ArrayList<>();
            String str;
            while ((str = br1.readLine()) != null) {
                list.add(str);
            }
            br1.close();
            Collections.shuffle(list);
            String namestr = list.get(0);
            System.out.println(namestr.split("-")[0]);
            //访问次数加一
            count++;
            //5.写出到文件
            bw.write(count+"");
            bw.close();

        }else {
            //访问次数大于三,就是点到指定人
            System.out.println("张三");
        }


    }
}
