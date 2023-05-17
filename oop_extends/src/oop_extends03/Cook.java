package oop_extends03;

public class Cook extends Employees {
    public Cook() {
    }

    public Cook(String id, String name, double bouds) {
        super(id, name, bouds);
    }

    @Override
    public void work() {
        System.out.println("厨师在炒菜");
    }

}
