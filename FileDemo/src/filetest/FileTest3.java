package filetest;

import com.sun.tools.javac.Main;

import java.io.File;

public class FileTest3 {
    public static void main(String[] args) {
        //查找电脑中所有的html文件

        findHTML();

    }


    public static void findHTML(){
        //获取所有盘符
        File[] files = File.listRoots();
        for (File src : files) {
            findHTML(src);
        }
    }

    private static void findHTML(File src){
        //1.进入src文件夹(没有权限进入的文件夹会返回null)
        File[] files = src.listFiles();
        //2.非空判断
        if (files!=null){
            //3.遍历数组的到src里的每一个文件夹,文件
            for (File f : files) {
                if (f.isFile()){
                    //4.判断:如果是文件,则判断是否符合
                    if (f.getName().endsWith(".html")){
                        System.out.println(f);
                    }
                }else {
                    //判断:如果是文件夹,就递归
                    //细节:再次调用本方法的时候,参数一定要是src的次一级路径
                    findHTML(f);
                }
            }
        }
    }
}
