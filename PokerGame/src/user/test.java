package user;

import java.util.Calendar;
import java.util.Scanner;

import static java.lang.System.exit;

public class test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入");
            int i = scanner.nextInt();
            switch (i) {
                case 1: {
                    System.out.println("注册");
                    register r=new register();
                   r.register();
                    break;
                }
                case 2:{
                    System.out.println("登录");
                    Login l=new Login();
                    l.login();
                    break;
                }
                case 3:{
                    exit(0);
                }

            }
        }
    }
}
