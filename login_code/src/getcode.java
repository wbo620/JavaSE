import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class getcode {

    public static void main(String[] args) {
        getCode();
    }

    public static String getCode() {
        ArrayList<Character> list = new ArrayList<>();// list存放字母
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        int size = list.size();
        // 先生成一个4个字母的验证码
        Random r = new Random();
        StringBuilder sb = new StringBuilder();// sb验证码
        for (int i = 0; i < 4; i++) {
            sb.append(list.get(r.nextInt(size)));
        }
        int num = r.nextInt(10);
        sb.append(num);
        char[] code = sb.toString().toCharArray();
        int randomIndex = r.nextInt(sb.length());

        char temp = code[randomIndex];
        code[randomIndex] = code[code.length - 1];
        code[code.length - 1] = temp;

        String str = Arrays.toString(code);
        System.out.println(str);
        return str;
    }

}
