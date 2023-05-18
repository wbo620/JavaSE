package filetest;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
    public static void main(String[] args) throws IOException {
        //需求:在当前模块下,创建aaa文件夹,并在其中创建aaa.txt文件

        //1.创建aaa.txt的父机路径
        File f=new File("aaa");
        //2.创建父级路径
        //如果aaa存在创建失败
        //不存在创建成功
        f.mkdir();
        //3.拼接父路径和子路径
        File f1=new File(f,"aaa.txt");
        boolean b = f1.createNewFile();
        if (b){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }

    }
}
