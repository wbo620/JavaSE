package oop_extends03;

public class Test {
    public static void main(String[] args) {
        Manager m=new Manager("001","zhangsan",5000,1000);
        System.out.println(m.getId()+", "+m.getName()+", "+m.getBouds()+", "+m.getJiangjin());
        m.eat();
        m.work();
        //Cook c=new Cook("002","wangwu",3000);
        Cook c=new Cook();
        c.setId("002");
        c.setName("wangwu");
        c.setBouds(4000);
        System.out.println(c.getId()+", "+c.getName()+", "+c.getBouds());
        c.work();
        c.eat();
    }
}
