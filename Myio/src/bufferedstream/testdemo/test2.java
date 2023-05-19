package bufferedstream.testdemo;

import java.io.*;
import java.util.TreeMap;

public class test2 {

    public static void main(String[] args) throws IOException {

        //需求:
        //给出一个乱序的csb文件,将正确的顺序复制到新的文件当中

        /*
        * 字符缓冲流,
        * 读取数据 , 读取每一行存入到字符串中,切割字符串,并添加到map集合当中
        * 对map集合进行排序,然后,在顺序写入新的文件
        * */
        BufferedReader br=new BufferedReader(new FileReader("src/csb.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/rightcsb.txt"));

        //HashMap<Integer,String> hm=new HashMap<Integer,String>();
        TreeMap<Integer,String>hm=new TreeMap<Integer,String>();
       String str;
       while ((str=br.readLine()) != null){
          /* String numstr = str.substring(0, 1);
           int num = Integer.parseInt(numstr);
           String s =  str.substring(2, str.length());
           hm.put(num,s);*/
           String[] arr = str.split("\\.");
           hm.put(Integer.parseInt(arr[0]),arr[1]);

       }
        System.out.println(hm);

        for (int i = 1; i <= hm.size(); i++) {
            String newstr =i+"."+ hm.get(i);
            bw.write(newstr);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
