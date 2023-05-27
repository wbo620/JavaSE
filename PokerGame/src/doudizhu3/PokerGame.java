package doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    //创建一副扑克牌
    static ArrayList<String> list = new ArrayList<String>();
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        //"♥","♠","♦","♣"
        //"3","4","5","6","7","8","9","10","J","Q","K","A","2"
        String[] color = {"♥", "♠", "♦", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //将牌放进集合中
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        //细节:大小王前面加了一个空格,为下面的排序用
        list.add(" 小王");
        list.add(" 大王");
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        //发牌

        ArrayList<String> lord = new ArrayList<>();//底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            //i表示索引
            //前三张当做底牌
            if (i < 3) {
                lord.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else {
                player3.add(list.get(i));
            }

        }

        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);


        lookPoker("底牌", lord);
        lookPoker("小明", player1);
        lookPoker("king", player2);
        lookPoker("小红", player3);

    }

    public void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            //Array.sort()插入排序 二分查找
            @Override
            public int compare(String o1, String o2) {
                //计算o1的价值和花色
                String c1 = o1.substring(0, 1);
                int vaule1 = getVaule(o1);
                //计算o2的价值和花色
                String c2 = o2.substring(0, 1);
                int vaule2 = getVaule(o2);
                int i = vaule1 - vaule2;
                return i == 0 ? c1.compareTo(c2) : i;
            }
        });
    }


    public void lookPoker(String name, ArrayList<String> list) {
        System.out.print(name + ":");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }

    public int getVaule(String poker) {
        //获取牌上的数字
        //拿着数字跟map集合进行比较
        String num = poker.substring(1);
        if (hm.containsKey(num)) {
            //存在,获取价值
            return hm.get(num);
        } else {
            //不存在类型转化
            return Integer.parseInt(num);
        }
    }

}
