package oop_extends05;

public class Dog extends Animal{
    public void lookHome(){
        System.out.println("狗看家");
    }

    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }
    @Override
    public void eat(String something){
        System.out.println(getAge()+"岁的"+getColor()+"狗两只前腿死死的抱着"+something);

    }

}
