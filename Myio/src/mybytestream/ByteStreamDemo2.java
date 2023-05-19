package mybytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/a.txt");
        byte []bytes={97,98,99,100,101};
      //写入一个字节数组
       fos.write(bytes);
       //写入一个自己数组,在i索引出开始,写入len个数据
       // fos.write(bytes,1,2);
        fos.close();
    }
}
