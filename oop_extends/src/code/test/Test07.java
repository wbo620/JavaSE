package code.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test07 {
    //手动录入学生信息,并存放在ArrayList表中,进行遍历
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        System.out.println("要录入学生信息的个数为:");
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            Student student=new Student();
            System.out.println("请输入学生姓名");
            String name = sc.next();
            System.out.println("请输入学生年龄");
            int age=sc.nextInt();
            student.setName(name);
            student.setAge(age);
            list.add(student);
        }
        for (int i = 0; i <list.size() ; i++) {
            Student stu=list.get(i);
            System.out.println("姓名:"+stu.getName()+" 年龄"+stu.getAge());
        }
    }
}
