package mytestdemo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*随机点名器2（学生独立完成）
            需求：
                一个文件里面存储了班级同学的信息，每一个学生信息占一行。
                 格式为：张三-男-23。
            要求通过程序实现随机点名器。
            运行效果：
                70%的概率随机到男生
                30%的概率随机到女生
                总共随机100万次，统计结果。
                注意观察：看生成男生和女生的比例是不是接近于7：3*/

        //关联要读取的文件
        BufferedReader br = new BufferedReader(new FileReader("src/随机姓名.txt"));
        //创建一个集合存放读取的数据
        ArrayList<String> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        //生成随机数,大于0.7在男生里抽,小于0.3在女生里抽
        Random r = new Random();
        //两个计数器分别计男女点到的次数
        int count1 = 0;
        int count2 = 0;
        //点一百万次名
        for (int i = 0; i < 1000000; i++) {
            double random = r.nextDouble();
            while (true) {
                //打乱集合
                Collections.shuffle(list);
                //取第一个元素
                String s = list.get(0);
                //切割字符串
                String[] arr = s.split("-");
                //大于0.3在男生里选
                if (random >= 0.3) {
                    if (arr[1].equals("男")) {
                        //System.out.println(s);
                        System.out.println(arr[0]);
                        count1++;
                        break;
                    }
                } else {
                    if (arr[1].equals("女")) {
                        // System.out.println(s);
                        System.out.println(arr[0]);
                        count2++;
                        break;
                    }
                }
            }
        }
        System.out.println("男:" + count1 / 1000000.0 + ",女:" + count2 / 1000000.0);

    }
}
