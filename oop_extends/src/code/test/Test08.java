package code.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
        User u1=new User("heima001","zhangsan","123321");
        User u2=new User("heima002","lisi","334343");
        User u3=new User("heima003","wangwu","134234");
        ArrayList<User> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        Scanner sc=new Scanner(System.in) ;
        System.out.println("请输入要查找的id");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            String s=list.get(i).getId();
            if (id.equals(s)){
                User u=new User();
                u=list.get(i);
                System.out.println(u.getId()+","+u.getUserName()+","+u.getPassword());
            }
        }

    }
}
