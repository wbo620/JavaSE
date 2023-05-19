package mytestdemo4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) throws IOException {
        /*
        * 输入账户名和密码进行登录
        * 登录超过三次锁定账户
        * */

        BufferedReader br = new BufferedReader(new FileReader("src/mytestdemo4/login.txt"));
        String line = br.readLine();
        br.close();
        String[] arr = line.split("&");

        System.out.println(Arrays.toString(arr));
        String rusername = arr[0].split("=")[1];
        String rpassword = arr[1].split("=")[1];
        int count = Integer.parseInt(arr[2].split("=")[1]);

        Scanner sc = new Scanner(System.in);
        if (count <3) {
            //输入信息
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();

            //判断
            if (username.equals(rusername) && password.equals(rpassword)) {
                System.out.println("登录成功");

            }else {
                System.out.println("登录失败");
                count++;
                BufferedWriter bw=new BufferedWriter(new FileWriter("src/mytestdemo4/login.txt"));
                bw.write("username="+rusername+"&"+"password="+rpassword+"&"+"count="+count);
                bw.close();

            }
        }else {
            System.out.println("错误次数超过三次,账号被锁定");
        }



    }
}
