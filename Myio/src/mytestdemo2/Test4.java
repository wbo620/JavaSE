package mytestdemo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test4 {
    public static void main(String[] args) throws IOException {
        /*随机点名器4（学生独立完成）
            需求：
                 一个文件里面存储了班级同学的姓名，每一个姓名占一行。
                 要求通过程序实现随机点名器。
            运行效果：
                被点到的学生不会再被点到
                 如果班级中所有的学生都点完了，需要自动的重新开启第二轮点名
                    细节1：假设班级有10个学生，每一轮中每一位学生只能被点到一次，程序运行10次，第一轮结束仁
                    细节2：第11次运行的时候，我们自己不需要手动操作本地文件，要求程序自动开始第二纶点名*/

        /*思路:
         * 1.创建缓冲输入流,把人名写到集合当中,另一个文件记录访问次数
         * 2.把集合当中的信息写出到新的文件当中
         * 3.获取集合中的0索引位置的信息打印出来,在进行删除
         * 4.把删除的集合写入到文件当中进行覆盖
         * 5.到达第11次,把新文件当中的数据拷贝到原文件当中
         * */
        //1.关联姓名文件
        BufferedReader br = new BufferedReader(new FileReader("src/allnames.txt"));
        //2.创建存放的集合
        ArrayList<String> list = new ArrayList<String>();
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        //如果集合长度不为0,表示原文件中还有信息
        if (list.size() != 0) {
            //3.打乱集合
            Collections.shuffle(list);

            String nameStr = list.get(0);
            //3.把每次打印的数据存放到临时文件当中
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/backups.txt", true));
            bw.write(nameStr);
            bw.newLine();
            bw.close();
            //打印姓名
            System.out.println(nameStr.split("-")[0]);
            //再集合中删除打印过得数据
            list.remove(nameStr);
            //将修正过的集合数据写入到源文件当中进行覆盖
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("src/allnames.txt"));
            for (String str2 : list) {
                bw2.write(str2);
                bw2.newLine();
            }
            bw2.close();
           //当集合长度为0,表示一轮结束,把创建的临时文件存放的信息再拷贝到源文件当中
        } else {
            //创建一个集合存放
            ArrayList<String> list1 = new ArrayList<>();
            BufferedReader br1 = new BufferedReader(new FileReader("src/backups.txt"));
            String line;
            while ((line = br1.readLine()) != null) {
                list1.add(line);
            }
            br.close();
            //将集合中的文件添加到原文件当中
            BufferedWriter bw3 = new BufferedWriter(new FileWriter("src/allnames.txt"));
            for (String s : list1) {
                bw3.write(s);
                bw3.newLine();
            }
            bw3.close();
            //临时文件删除
            new File("src/backups.txt").delete();

        }

    }


}

