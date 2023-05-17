package a01students;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static a01students.StudentSystem.StudentsSystem;

public class App {
    public static void main(String[] args) {
        System.out.println("欢迎来到学生管理系统");
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("请选择操作:1.登录  2.注册  3.忘记密码  4.退出");
            int choose = sc.nextInt();
            switch (choose) {
                case 1 -> login(list);
                case 2 -> register(list);
                case 3 -> forgerPassword(list);
                case 4 -> {
                    System.out.println("谢谢使用,再见");
                    System.exit(0);
                }
                default -> System.out.println("没有此选项");
            }
        }
    }

    //忘记密码
    private static void forgerPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        if (!contains(list, username)) {
            System.out.println("用户名不存在,请先注册");
            return;
        }
        System.out.println("请输入身份证号码");
        String ID = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();
        int index = findIndex(list, username);
        if (index >= 0) {
            User u = list.get(index);
            if (!((u.getPersonId().equalsIgnoreCase(ID)) && (u.getPhoneNumber().equals(phoneNumber)))) {
                System.out.println("身份证号码或手机号码有误,不能修改密码");
                return;
            }
            //到这表示信息正确,开始修改密码
            String newPassword;
            while (true) {
                System.out.println("请输入新的密码");
                newPassword = sc.next();
                System.out.println("请再次输入新的密码");
                String againNewPassword = sc.next();
                if (!checkPassword(newPassword, againNewPassword)) {
                    System.out.println("密码不一致");
                } else {
                    break;
                }
            }
            u.setPassword(newPassword);
            System.out.println("修改成功");
        }

    }

    //返回用户在集合中索引
    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String name = user.getUsername();
            if (username.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    //登录
    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("登录");
        String username;
        String password;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("用户名不存在,请注册后登录");
                continue;
            }
            System.out.println("请输入密码");
            password = sc.next();

            while (true) {
                System.out.println("请输入验证码");
                String code = getCode();
                System.out.println("验证码为:" + code);
                if (!code.equalsIgnoreCase(sc.next())) {
                    System.out.println("验证码错误,请重新输入");
                    continue;
                }
                break;
            }
            User u = new User(username, null, password, null);
            boolean result = checkUserInfo(list, u);
            while (true) {
                if (!result) {
                    System.out.println("用户名或密码错误,请重新输入");
                } else {
                    System.out.println("登录成功");
                    StudentsSystem();
                }
            }
        }

    }

    //检验用户名密码是否正确
    private static boolean checkUserInfo(ArrayList<User> list, User u) {
        for (User user : list) {
            if ((user.getUsername().equals(u.getUsername())) && (user.getPassword().equals(u.getPassword()))) {
                return true;
            }
        }
        return false;
    }

    //注册
    private static void register(ArrayList<User> list) {
        System.out.println("注册");
        User user = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入同户名");
            String username = sc.next();
            if (!checkUserName(username)) {
                System.out.println("用户名不合法,请重新输入");
                continue;
            }
            //在判断用户名是否唯一
            boolean flag = contains(list, username);
            if (flag) {
                System.out.println("用户名已存在,请重新输入");
                continue;
            } else {
                //用户名合法,添加到user对象当中
                user.setUsername(username);
                break;
            }

        }
        String password;
        while (true) {
            System.out.println("请输入密码");
            password = sc.next();
            System.out.println("请再次输入密码");
            String againPassword = sc.next();
            if (checkPassword(password, againPassword)) {
                //执行到这表示两次密码一致,添加到user对象中
                user.setPassword(password);
                break;
            } else {
                System.out.println("两次密码不一致,请重新输入");
                continue;
            }
        }


        while (true) {
            System.out.println("请输入身份证号");
            String userID = sc.next();
            if (!checkUserID(userID)) {
                System.out.println("身份证号码不正确");
                continue;
            }
            user.setPersonId(userID);
            break;
        }
        while (true) {
            System.out.println("请输入手机号码");
            String phoneNumber = sc.next();
            if (!checkPhoneNumber(phoneNumber)) {
                System.out.println("手机号码不正确");
            } else {
                user.setPhoneNumber(phoneNumber);
                break;

            }
        }
        list.add(user);
        printList(list);
    }

    //检验用户名
    public static boolean checkUserName(String username) {
        //用户名校验
        int len = username.length();
        //判断用户名位数是否满足要求
        if (len <= 3 || len >= 15) {
            System.out.println("用户名长度不符合要求,请重新输入");
            return false;
        }
        char c;
        //判断用户名是否是字母和数字
        for (int i = 0; i < len; i++) {
            c = username.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                System.out.println("格式错误,请重新输入");
                return false;
            }

        }
        //到此表示全是字母和数字
        //开始判断是否至少含有一个字母
        int count = 0;//用来记录字母的个数
        for (int j = 0; j < len; j++) {
            c = username.charAt(j);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                //到此表示用户名正确
                count++;
            }
            if (count > 0) {
                System.out.println("用户名格式正确");
                return true;
            }

        }
        System.out.println("不能全为数字,请重新输入");
        return false;
    }

    //检验密码
    public static boolean checkPassword(String password, String againPassword) {
        if (password.equals(againPassword)) {
            return true;
        } else {
            return false;
        }
    }

    //检验身份号码
    public static boolean checkUserID(String ID) {
        //身份证号长度必须为18
        int len = ID.length();
        if (len != 18) {
            System.out.println("身份证号长度不正确");
            return false;
        }
        //身份证号开头不能为0
        if (ID.charAt(0) != '0') {
            //前17位必须是数字
            for (int i = 0; i < len - 1; i++) {
                char c = ID.charAt(i);
                if (!(c >= '0' && c <= '9')) {
                    System.out.println("前17位必须为数字");
                    return false;
                }
            }
            char s = ID.charAt(len - 1);
            if (!((s >= '0' && s <= '9') || (s == 'X') || (s == 'x'))) {
                return false;
            }
        }
        return true;
    }

    //检验手机号
    public static boolean checkPhoneNumber(String phoneNumber) {
        int len = phoneNumber.length();
        if (len != 11) {
            System.out.println("手机号码长度不正确");
            return false;
        }
        if (phoneNumber.charAt(0) != '1') {
            System.out.println("手机号码首位不正确");
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    //打印集合
    public static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getUsername() + ", " + u.getPassword() + ", " + u.getPersonId() + ", " + u.getPhoneNumber());
        }

    }
    //判断用户名是否存在
    public static boolean contains(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);

            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //生成验证码
    public static String getCode() {
        ArrayList<Character> list = new ArrayList<>();//list存放字母
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        int size = list.size();
        //先生成一个4个字母的验证码
        Random r = new Random();
        StringBuilder sb = new StringBuilder();//sb验证码
        for (int i = 0; i < size; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int num = r.nextInt(10);
        sb.append(num);
        //变成字符数组
        char[] code = sb.toString().toCharArray();
        int randomIndex = r.nextInt(code.length);
        //将最后一个索引所对应的数字跟随机索引所对应的元素交换位置
        char temp = code[randomIndex];
        code[randomIndex] = code[code.length - 1];
        code[code.length - 1] = temp;

        return new String(code);

    }
}


