import org.w3c.dom.Text;

import java.util.Random;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        //给出正确的用户名和密码
        String rightUserName="zhanghao";
        String rightPassworld="123456";
        char []arr=new char[52];
        //存放字母的数组
        for (int i = 0; i < 52; i++) {
            arr[i]=(char)('a'+i);
            if(i>25){
                arr[i]=(char)('A'-26+i);
            }
        }


        Random r=new Random();


        //输入用户名和密码 3次机会
        for (int i = 0; i < 3; i++) {
            StringBuilder sb=new StringBuilder();
            //每次都生成一个验证码
            //生成验证码存放在数组中
            char []test=new char[4];
            for (int j = 0; j < test.length; j++) {
                int s=r.nextInt(arr.length);
                test[j]=arr[s];
            }

            sb.append(test);
            String start=sb.toString();
            System.out.println("请输入用户名,密码和验证码");
            System.out.println("验证码:"+start);
            Scanner sc=new Scanner(System.in);
            String userName=sc.next();
            String passworld=sc.next();
            String Text=sc.next();
            //如果输入全对登陆成功
            if (userName.equals(rightUserName)&&passworld.equals(rightPassworld)
                    &&Text.equalsIgnoreCase(start)){
                System.out.println("登录成功");
            }
            else {
                System.out.println("账号或密码错误,还剩" + (2-i) + "次机会");

            }

        }

    }
}
