package oop_extends05;

public class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫捉老鼠");
    }

    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }
    @Override
    public void eat(String something){
        System.out.println(getAge()+"岁的"+getColor()+"猫眯着眼睛侧着头吃"+something);
    }
}
