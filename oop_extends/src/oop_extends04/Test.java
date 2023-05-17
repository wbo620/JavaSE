package oop_extends04;

public class Test {
    public static void main(String[] args) {
        Buyer b=new Buyer("001","xiaoliu");
        System.out.println(b.getId()+", "+b.getName());
        b.work();

    }
}
 