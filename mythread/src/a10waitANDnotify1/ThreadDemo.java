package a10waitANDnotify1;

public class ThreadDemo {
    public static void main(String[] args) {
        Foodie f = new Foodie();
        Cook c = new Cook();

        f.setName("吃货");
        c.setName("厨师");
        f.start();

        c.start();


    }

}
