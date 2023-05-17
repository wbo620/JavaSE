package a01students;

import java.util.ArrayList;
import java.util.Scanner;

//教务管理系统
public class StudentSystem {
    private static final String ADD_STUDENT = "1";
    private static final String DEL_STUDENT = "2";
    private static final String ALTER_STUDENT = "3";
    private static final String SHOW_STUDENT = "4";
    private static final String EXIT = "5";

    public static void StudentsSystem() {
        System.out.println("-----------欢迎进入学生管理系统-----------");
        ArrayList<Student> list = new ArrayList<>();
        //  Student stu=new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择你的操作");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");

            String flag = sc.next();
            loop:
            switch (flag) {
                case ADD_STUDENT -> addStudent(list);
                case DEL_STUDENT -> delStudent(list);
                case ALTER_STUDENT -> alterStudent(list);
                case SHOW_STUDENT -> showStudent(list);
                case EXIT ->
                    // break loop;
                        System.exit(0);
                default -> System.out.println("没有该选项");

            }

        }
    }

    //查询学生
    private static void showStudent(ArrayList<Student> list) {
        if (list.size() != 0) {
            System.out.println("ID\t\t\t姓名\t\t年龄\t\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getId() + ", " + stu.getName() + ", " + stu.getAge() + "," + stu.getHomeAddress());
            }
        } else {
            System.out.println("数据库中没有学生信息");
        }
    }

    //修改学生
    private static void alterStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的ID");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("没有此ID,请输入正确的ID");
            return;
        }
        Student s = list.get(index);
        System.out.println("请输入要修改的姓名");
        String newName = sc.next();
        s.setName(newName);
        System.out.println("请输入要修改的年龄");
        int newAge = sc.nextInt();
        s.setAge(newAge);
        System.out.println("请输入要修改的家庭地址");
        String newHome = sc.next();
        s.setHomeAddress(newHome);
        System.out.println("修改完成");

    }

    //删除学生
    private static void delStudent(ArrayList<Student> list) {
        //1.判断结合是否有元素,有则返回对应索引
        Scanner sc = new Scanner(System.in);
        //2.没有则打印集合为空
        System.out.println("请输入要删除的ID");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("删除成功");
        } else {
            System.out.println("系统中没有该ID信息,删除失败");

        }
    }

    //添加学生
    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID");
        String id = sc.next();
        //检验id是否唯一
        if (contines(list, id)) {//返回值为true表示集合中有相同的,
            System.out.println("ID已存在,请重新输入");
        }
        //到此表示id唯一,可以继续输入接下来的信息
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入家庭住址");
        String home = sc.next();
        Student s = new Student(id, name, age, home);
        list.add(s);
        System.out.println("添加成功");

    }

    //判断id在集合中是否存在
    private static boolean contines(ArrayList<Student> list, String id) {
        return getIndex(list, id) >= 0;
    }

    //通过id获取索引索引
    private static int getIndex(ArrayList<Student> list, String id) {
        if (list.size() > 0) {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                Student student = list.get(i);
                if (student.getId().equals(id)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
