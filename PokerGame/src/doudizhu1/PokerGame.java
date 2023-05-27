package doudizhu1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    //创建一副扑克牌
    static ArrayList<String> list = new ArrayList<String>();

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
        list.add("小王");
        list.add("大王");
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
        lookPoker("底牌", lord);
        lookPoker("小明", player1);
        lookPoker("king", player2);
        lookPoker("小红", player3);

    }

    public  void lookPoker(String name, ArrayList<String> list) {
        System.out.print(name + ":");
        for (String poker : list) {
            System.out.print(poker+" ");
        }
        System.out.println();
    }

}