package oop_extends05;

public class Test {
    public static void main(String[] args) {
        Person p=new Person("老王", 23);
        Cat c=new Cat(2,"白");
        p.keepPet(c,"鱼");
        

        Dog d=new Dog(3,"黑");
        p.keepPet(d,"骨头");


    }
}
