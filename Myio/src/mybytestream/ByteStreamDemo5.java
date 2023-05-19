package mybytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        //读取文件
        FileInputStream fis = new FileInputStream("/Users/hallen/Desktop/202221023025 武博.docx");
        //写出文件
        FileOutputStream fos=new FileOutputStream("src/b.txt");
        int b;
        while ((b=fis.read())!=-1){
            fos.write(b);
        }
        //细节:先打开的文件后关闭
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();

        System.out.println((end-start));
    }
}
