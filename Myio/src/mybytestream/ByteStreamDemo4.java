package mybytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/a.txt");
        //文件不存在则会报错

        //int read = fis.read();
        //读取到末尾,没有字符,会返回-1
//        System.out.println(read);
//        System.out.println((char) read);

        //循环读取
        int b;
        while ((b=fis.read()) != -1) {
            System.out.print((char)b);
        }
        fis.close();

    }
}
