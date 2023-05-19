package myobjectstream;

import java.io.*;
import java.util.ArrayList;

public class ObjectStreamDemo4 {
    //读取Demo3中的序列化流文件,
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/osd.txt"));

      ArrayList<Student> list=(ArrayList<Student>) ois.readObject();

        for (Student student : list) {
            System.out.println(student);
        }

        ois.close();
    }




}
