package bytestreamtestdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDemo2 {
    //加密文件,与解密
    public static void main(String[] args) throws IOException {
        //想要加密或解密的文件
        FileInputStream fis=new FileInputStream("src/endy.txt");
        //目标文件
        FileOutputStream fos=new FileOutputStream("src/redu.txt");
       //读取数据
        int len;
        while ((len=fis.read())!=-1){
            //异或加密
            fos.write(len^10);
        }
        fos.close();
        fis.close();
    }
}
