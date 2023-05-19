package mytestdemo3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) throws IOException {

        //1.关联文件,读取数据存放在集合当中

            BufferedReader br=new BufferedReader(new FileReader("src/mytestdemo3/names.txt"));
            ArrayList<Student> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("-");
                Student stu=new Student(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3]));
                list.add(stu);
            }
            br.close();
            //System.out.println(list);
            //2.计算权重总和
            double weight=0;
            for (Student stu : list) {
                weight += stu.getWeight();
            }
           // System.out.println(weight);

            //3.计算每个人的权重占比
            double arr[]=new double[list.size()];
            int i=0;
            for (Student stu : list) {
               arr[i]=stu.getWeight() / weight;
                i++;
            }
            //4.计算每个人的权重占比范围
            for (int j = 1; j < arr.length; j++) {
                arr[j]=arr[j]+arr[j-1];
            }

            //4.随机抽取
            double random=Math.random();
            int index = -Arrays.binarySearch(arr, random)-1;
            System.out.println(index);
            Student stu = list.get(index);
            System.out.println(stu);
            //5.修改权重
            double weight2 = stu.getWeight() / 2;
            stu.setWeight(weight2);

            //6.写出数据

            BufferedWriter bw=new BufferedWriter(new FileWriter("src/mytestdemo3/names.txt"));
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();


    }
}
