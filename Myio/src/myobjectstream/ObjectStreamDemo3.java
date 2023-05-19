package myobjectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*需求：
        将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
        */

        Student s1=new Student("zhangsan",23,"上海");
        Student s2=new Student("lisi",25,"西域");
        Student s3=new Student("wangwu",22,"北疆");

        ArrayList<Student> list=new ArrayList<Student>();

        Collections.addAll(list,s1,s2,s3);
        for (Student student : list) {
            System.out.println(student);
        }

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/osd.txt"));
        oos.writeObject(list);

        oos.close();
    }
}
