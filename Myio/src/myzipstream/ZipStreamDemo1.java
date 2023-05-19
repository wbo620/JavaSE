package myzipstream;

import com.sun.tools.javac.Main;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    //解压
    public static void main(String[] args) throws IOException {

        //源文件
        File src = new File("/Users/hallen/Downloads/生鲜商城.zip");
        //目标文件地址
        File dest = new File("/Users/hallen/生鲜unzip");
        unzip(src, dest);


    }

    //创建一个解压方法
    public static void unzip(File src, File dest) throws IOException {
        //解压本质:把压缩包里的每一个文件,文件夹遍历,按层级创建到目标文件夹
        //传建一个压缩流,关联要操作的压缩文件
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        //获取压缩包里的每一个entry对象
        //表示压缩包里的每一个文件或文件夹
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            System.out.println(entry);

            if (entry.isDirectory()) {
                //如果遍历到的是文件夹,就创建文件夹,并且要在当前路径下创建
                File file = new File(dest, entry.toString());
                file.mkdirs();

            } else {
                //是文件,就复制
                //创建一个文件输出流,把他存放到dest文件夹当中,按层级存放
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while ((b = zip.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                //表示压缩包中的一个文件存放完毕
                zip.closeEntry();
            }
        }
        zip.close();

    }

}
