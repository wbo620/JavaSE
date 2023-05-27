package user;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class register {
    static ArrayList<User> list=new ArrayList<User>();
    public static void register() {
        System.out.println("注册界面");

        User user = new User();
        Scanner sc=new Scanner(System.in);

        while (true) {
            System.out.println("请输入用户名");
            String username=sc.next();
            if (!checkUserName(list,username)){
                continue;
            }
            String password= null;
            while (true) {
                System.out.println("请输入密码");
                password = sc.next();
                System.out.println("请再次输入密码");
                String ageinPasswor =sc.next();
                if(!ageinPasswor.equals(password)){
                    continue;
                }
                break;
            }
            String Id = null;
            while (true) {
                System.out.println("请输入身份证号码");
                Id = sc.next();
                if (!checkIdCard(list,Id)){
                    continue;
                }
                break;
            }
            String phone = null;
            while (true) {
                System.out.println("请输入手机号");
                phone = sc.next();
                if (!checkPhone(list,phone)){
                    continue;
                }
                break;
            }
            user.setName(username);
            user.setPhoneNumber(phone);
            user.setID(Id);
            user.setPassword(password);
            break;
        }


    }
    //手机号检验
    private static boolean checkPhone(ArrayList<User> list, String phone) {
        //长度检验
        String regex="[1-9]\\d{10}";
        if (!phone.matches(regex)){
            System.out.println("手机号格式错误");
            return false;
        }
        return true;
    }

    //用户名验证
    private static boolean checkUserName(ArrayList<User> list,String username) {
        //用户名唯一
        if (list.contains(username)){
            System.out.println("用户名已存在");
            return false;
        }
        //长度3-15
        String regex="^(?![0-9]{3,15}$)[a-zA-Z0-9]{3,15}$";
        if (!username.matches(regex)){
            System.out.println("用户名格式错误");
            return false;
        }
        return true;
    }
    //身份证号验证
    private static boolean checkIdCard(ArrayList<User> list,String idCard) {
        //身份证号唯一
        if (list.contains(idCard)){
            System.out.println("身份证号已存在");
            return false;
        }
        //长度18,不能0开头,前17位是数字,最后一位可以是数字Xx
        String regex="[1-9]\\d{16}[0-9Xx]";
        if (!idCard.matches(regex)){
            System.out.println("身份证号格式错误");
            return false;
        }
        return true;
    }
}
