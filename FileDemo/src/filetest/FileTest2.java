package filetest;

import java.io.File;

public class FileTest2 {
    public static void main(String[] args) {
        /*需求：
        定义一个方法找某一个文件夹中，是否有以m4a结尾的文件。
        （暂时不需要考虑子文件夹)
        */
        File file = new File("/Users/hallen/java_code/FileDemo/aaa/bbb");
        System.out.println(haveM4A(file));


    }

      public static boolean haveM4A(File file) {
          File[] arr = file.listFiles();
          if (arr!=null) {
              for (File f : arr) {
                if (f.isFile()&&f.getName().endsWith(".m4a")){
                    return true;
                }
              }
          }
          return false;
      }
}
