package bytestreamtestdemo;

import java.io.*;
import java.util.Arrays;

public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        //将文件中的数据进行排序后
        //拷贝到新文件中
        FileInputStream fis = new FileInputStream("src/b.txt");
        StringBuilder sb=new StringBuilder();
        FileOutputStream fos=new FileOutputStream("src/copySort.txt");
       //1.读取数据
        int b;
        while ((b=fis.read()) != -1){
            sb.append((char) b);
        }
        //2.排序
        /*String[] arr = sb.toString().split("-");
        Arrays.sort(arr);
        StringBuilder sp=new StringBuilder();

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i <arr.length; i++) {
            sp.append(arr[i]);
            sp.append("-");
        }
        System.out.println(sp);
        //3.拷贝
        for (int i = 0; i < sp.length()-1; i++) {
            fos.write(sp.charAt(i));

        }*/

        //改写
        //2.排序
        Integer[] arr = Arrays.stream(sb.toString()
                        .split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(arr));

        //3.写出
        FileWriter fw=new FileWriter("src/copySort.txt");
        String str = Arrays.toString(arr).replace(",", "-");
        String substring = str.substring(1, str.length() - 1);
        fw.write(substring);

       // fos.close();
        fw.close();
        fis.close();
    }
}
