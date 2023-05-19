package myprintstream;

import java.io.*;
import java.nio.charset.Charset;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        //1.创建打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("src/ps.txt"),true, Charset.forName("UTF-8"));
        //2.写入数据
        ps.println("Hello");
        ps.print("World");
        ps.printf("%s在干嘛\n", "小明");
        //3.关流
        ps.close();
    }
}
