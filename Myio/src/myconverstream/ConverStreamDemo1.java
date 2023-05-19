package myconverstream;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class ConverStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码读取（了解）
            因为JDK11：这种方式被淘汰了。替代方案(掌握)
            F:\JavaSE最新版\day29-IO（其他流）\资料\gbkfile.txt
        */
            /*//1.创建对象并指定字符编码
                 InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\gbkfile.txt"),"GBK");
            //2.读取数据
               int ch;
               while ((ch = isr.read()) != -1){
               System.out.print((char)ch);
            3
            //3.释放资源
            isr.close();*/
        //关联文件
        FileReader fr = new FileReader("src/file1.txt", Charset.forName("utf-8"));
        //2.读取数据
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        //3.释放资源
        fr.close();

    }
}
