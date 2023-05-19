package mybytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {
        //一次读取多个字节数据

        FileInputStream fis = new FileInputStream("src/a.txt");

        byte[] bytes = new byte[2];
        int len;
        while (( len = fis.read(bytes))!=-1) {
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
    }
}
