import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
    /*需求：
            键盘录入自己心仪的女朋友姓名和年龄。
            姓名的长度在3-10之间，
            年龄的范围为18-40岁，
            超出这个范围是异常数据不能赋值，需要重新录入，一直录到正确为止。
            提示：
            需要考虑用户在键盘录入时的所有情况。
            比如：录入年龄时超出范围，录入年龄时录入了abc等情况*/
        GrilFrend g=new GrilFrend();
        Scanner sc=new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入姓名");
                g.setName(sc.nextLine());
                System.out.println("请输入年龄");
                String age = sc.nextLine();
                g.setAge(Integer.parseInt(age));
                break;
            } catch (NameFormatExample e) {
                e.printStackTrace();
            }catch (AgeOutBoundsException e) {
                e.printStackTrace();
            }
        }

        System.out.println(g);




    }
}
