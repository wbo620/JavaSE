package filetest;

import java.io.File;

public class FileTest4 {
    public static void main(String[] args) {
        /*
        删除一个多级文件夹
        如果我们要删除一个有内容的文件夹
            1.先删除文件夹里面所有的内容
            2.再删除自己
        */

        File src=new File("/Users/hallen/java_code/FileDemo/aaa");
        delete(src);
    }

    public static void delete(File src){
        //1.先删除文件夹里的内容
        //遍历
        File[] files = src.listFiles();
        if(files!= null){
            for (File file : files) {
                if (file.isFile()){
                    //是文件,删除
                    file.delete();
                }else {
                    //是文件夹,递归调用
                    delete(file);
                }
            }
        }
        //2.再删除自己
        src.delete();
    }
}
