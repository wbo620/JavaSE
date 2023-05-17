package oop_extends03;

public class Manager extends Employees {
    double jiangjin;

    public Manager() {

    }

    public Manager(String id, String name, double bouds, double jiangjin) {
        super(id, name, bouds);
        this.jiangjin = jiangjin;
    }

    public double getJiangjin() {
        return jiangjin;
    }

    public void setJiangjin(double jiangjin) {
        this.jiangjin = jiangjin;
    }

    @Override
    public void work() {
        System.out.println("管理其他人");
    }
}
