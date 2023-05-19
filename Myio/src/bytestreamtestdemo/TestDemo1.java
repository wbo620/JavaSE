package bytestreamtestdemo;

import java.io.*;

public class TestDemo1 {
    //拷贝一个文件夹,包含里面的子文件
    public static void main(String[] args) throws IOException {
        File src = new File("/Users/hallen/Mysite的副本");
        File dest = new File("/Users/hallen/bbb");
        copy(src,dest);
    }
    public static void copy(File src,File dest) throws IOException {
        //创建要复制的文件夹
        dest.mkdir();
        //进入数据源
        File[] files = src.listFiles();
        if (files!=null) {
            //遍历数组
            for (File file : files) {
                //如果是文件,拷贝
                if (file.isFile()){
                    //源文件
                    FileInputStream fis = new FileInputStream(file);
                    //要写入的新文件,
                    // new File(dest,file.getName()):新文件,在指定路径下创建,跟源文件同名
                    FileOutputStream fos=new FileOutputStream(new File(dest,file.getName()));
                    byte[] arr=new byte[1024];
                    int len;
                    while ((len = fis.read(arr))!=-1){
                        fos.write(arr,0,len);
                    }
                    //是文件夹,递归
                }else {
                    copy(file,new File(dest,file.getName()));
                }
            }
        }

    }
}
