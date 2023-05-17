package code.test;

public class Test05 {
    public static void main(String[] args) {
        String s1 = "12";
        String s2 = "12";
        String s = new String();
        int num1 = strToInt(s1);
        int num2 = strToInt(s2);
        System.out.println("结果为:" + num1 * num2);

    }

    //将字符串变为整数
    public static int strToInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int s = c - '0';
            result = result + s;
            result *= 10;

        }
        result /= 10;
        return result;
    }
}
