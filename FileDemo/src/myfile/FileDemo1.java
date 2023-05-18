package myfile;

import com.sun.jdi.ArrayReference;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo1 {

    public static void main(String[] args) {
        //文件过滤器

//        File[] arr = File.listRoots();
//        System.out.println(Arrays.toString(arr));
        //1.
//        File f1=new File("/Users/hallen/Mysite");
//        String[] arr2 = f1.list();
//        for (String s : arr2) {
//            System.out.println(s);
//        }
       // 2.
//        File f2=new File("/Users/hallen/Mysite");
//        String[] arr3 = f2.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                File file = new File(dir ,name);
//                return file.isFile() && name.endsWith(".html");
//            }
//        });
//        System.out.println(Arrays.toString(arr3));

        //3.文件过滤器(掌握)
      File f=new File("/Users/hallen/Mysite");
        File[] arr = f.listFiles();
        for (File file : arr) {
           if(file.isFile()&&file.getName().endsWith(".html")){
                System.out.println(file);
            }
        }
        //4.
//        File f3=new File("/Users/hallen/Mysite");
//        File[] arr3 = f3.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isFile() && pathname.getName().endsWith(".html");
//            }
//        });
//        System.out.println(Arrays.toString(arr3));

                File f4=new File("/Users/hallen/Mysite");
        File[] arr4 = f4.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir,name);
                return file.isFile() && name.endsWith(".html");
            }
        });
        System.out.println(Arrays.toString(arr4));

    }
}
