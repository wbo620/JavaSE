package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CodeUtil {
    public static String getCode() {
        //生成验证码
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        Random r = new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }
        sb.append(r.nextInt(10));
        char[] array = sb.toString().toCharArray();


        int randomIndex = r.nextInt(array.length);
        int numIndex = array.length -1;

        char temp =array[randomIndex];
        array[randomIndex] = array[numIndex];
        array[numIndex] = temp;
        String s="";
        for (int i = 0; i < array.length; i++) s = s + array[i];

        return s;
    }


}
