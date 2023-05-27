package user;

import Util.CodeUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void login() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
            String rightCode = CodeUtil.getCode();
            System.out.println(rightCode);
            System.out.println("请输入验证码");
            String code = sc.next();
            if (!register.list.contains(username)) {
                System.out.println("用户名未注册");
                return;
            }
            if (!register.list.get(register.list.indexOf(username)).equals(password)) {
                System.out.println("密码错误");
                continue;
            }
            if (!code.equalsIgnoreCase(rightCode)){
                System.out.println("验证码错误,请重新输入");
                continue;
            }
            break;
        }
        System.out.println("登录成功");
    }
}
