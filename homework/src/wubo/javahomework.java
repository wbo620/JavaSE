package wubo;
    class people {
        String name;
        String no;

        public people(String name, String no) {
            this.name = name;
            this.no = no;
        }

        public String getName(){
            return name;
        }
        public String getNo(){
            return no;
        }

    }
    class Animal {
        String name;
        public Animal(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void eat(){
            System.out.println("动物在吃食物");
        }
    }
    class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public void eat() {
            System.out.println(getName() + "在吃鱼");
        }
    }

    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
        public void eat() {
            System.out.println(getName() + "在吃骨头");
        }
    }
public class javahomework {
    public static void main(String[] args) {
     people p = new people("武博","202221023025");
     Animal cat=new Cat("小咪");
        System.out.println(p.name+",学号"+p.no+"养了一只猫"+",他的名字叫"+cat.getName());
        cat.eat();
        Animal dog = new Dog("航航");
        System.out.println(p.name + "还养了一只狗" + ",他的名字叫" + dog.getName());
        dog.eat();
    }

}
