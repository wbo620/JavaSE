package wubo;

public class homework {
    public  static void main(String[] args) {
        prople p=new prople("武博","202221023025");
        Animals cat=new Ccat();
        cat.setName("咪咪");
        System.out.println(p.getName()+","+"学号:"+p.getNo()+",养了一只猫,他的名字叫"+cat.getName());
        cat.eat();
        Animals giraffe=new Giraffe();
        giraffe.setName("航航");
        System.out.println(p.getName()+"还养了一只长颈鹿,他的名字叫"+giraffe.getName());
        giraffe.eat();

    }
}
