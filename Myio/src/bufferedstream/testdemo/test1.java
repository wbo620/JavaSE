package bufferedstream.testdemo;

import java.io.*;

public class test1 {
    public static void main(String[] args) throws IOException {
        //需求:拷贝一个文件,分别用一下四种情况,分别计算用时
        long start = System.currentTimeMillis();
     /*   //1.字节流,基本流,一次读取一个字节
        FileInputStream fis=new FileInputStream("src/file1.txt");
        FileOutputStream fos=new FileOutputStream("src/copyfile1.txt");
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fos.close();
        fis.close();
        //843ms
*/
       /*     //2.字节流,基本流,一次读取一个字节数组
        FileInputStream fis=new FileInputStream("src/file1.txt");
        FileOutputStream fos=new FileOutputStream("src/copyfile2.txt");
        byte[] bytes=new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
        //6ms*/

   /*    //3.字节缓冲流,一次读取一个字节
       BufferedInputStream bis=new BufferedInputStream(new FileInputStream("src/file1.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("src/copyfile3.txt"));

        int b;
        while((b=bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
        //用时30ms*/

      /*  //4.字节缓冲流,一次读取一个字节数组
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("src/file1.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("src/copyfile4.txt"));

        byte[] buf = new byte[1024];
        int len;
        while((len=bis.read(buf)) != -1){
            bos.write(len);
        }
        bos.close();
        bis.close();
        //7ms
*/

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
