package myzipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    //将一个文件夹及里面的内容进行压缩(忽略了空的文件夹)
    public static void main(String[] args) throws IOException {

        //要压缩的文件
        File src = new File("/Users/hallen/Mysite");
        //压缩后的位置,就是压缩完放在那里
        //放在src的父级路径下
        File destParent = src.getParentFile();//Users/hallen
        //目标的压缩文件位置及名称
        //跟源文件在同一目录下,并且名称跟源文件同名+.zip
        File dest = new File(destParent +"/"+ src.getName() + ".zip");
        //创建压缩流,关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));

        toZip(src, zos, src.getName());
        zos.close();

    }

         /*
         作用：获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
         参数一：数据源
         参数二：压缩流
         参数三：压缩包内部的路径*/
    public static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        //进入文件夹
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                ZipEntry entry = new ZipEntry(name + "/" + file.getName());
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);
                int b;
                while ((b = fis.read()) != -1) {
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();

            } else {
                File newFile = new File(name + "/" + file.getName());
                newFile.mkdirs();
                toZip(file, zos, name + "/" + file.getName());
            }
        }


    }


}

