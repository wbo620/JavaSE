package filetest;

import javax.swing.*;
import java.io.File;

public class FileTest5 {

    public static void main(String[] args) {
        File src=new File("/Users/hallen/java_code/FileDemo/aaa");
        System.out.println(getLen(src));
    }
    /*
           作用：统计一个文件夹的总大小
           参数： 表示要统计的那个文件夹
           返回值： 统计之后的结果
           文件夹的总大小：说白了，文件夹里面所有文件的大小
         */
  public static long getLen(File src){
      //1.存放大小
        long len=0;
        //2.进入src文件,遍历文件夹
      File[] files = src.listFiles();
      for (File file : files) {
          if (file.isFile()){
              //判断:如果是文件,累加文件的大小
              len+=file.length();
          }else {
              //如果是文件夹,累加文件夹的大小,并递归调用
              len+=getLen(file);
          }
      }
      return len;
  }

}
