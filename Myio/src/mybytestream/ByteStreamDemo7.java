package mybytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo7 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/hallen/Desktop/jiji.m4a");
        FileOutputStream fos=new FileOutputStream("src/aaa.m4a");

        //每次读取数据的大小,设置为5m
        byte[] bytes = new byte[1024*1024*5];
        int len;
        while ((len = fis.read(bytes))!=-1){
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }
}
