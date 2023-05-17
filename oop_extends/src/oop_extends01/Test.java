package oop_extends01;

public class Test {
//    public static void main(String[] args) {
//        Cat lihua =new Cat();
//        lihua.cathMouse();
//        Taidi taidi=new Taidi();
//        taidi.drink();
//
//    }
public static void main(String[] args) {
    Zi zi=new Zi();
    zi.show();
}
}

        class  Fu{
            String name="FU";
            String hobby="喝茶";
        }
         class Zi extends Fu{
            String name="Zi";
            String game="吃鸡";

            public void show(){
                //打印zi
                System.out.println(name);
                System.out.println(this.name);
                //打印fu
                System.out.println(super.name);
                //打印喝茶
                System.out.println(hobby);
                System.out.println(this.hobby);
                System.out.println(super.hobby);
                //打印吃鸡
                System.out.println(game);
                System.out.println(this.game);
            }
        }


