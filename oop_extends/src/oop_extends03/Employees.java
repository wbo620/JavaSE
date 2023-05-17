package oop_extends03;

public class Employees {
   private String id;
    private String name;
    private double bouds;

    public Employees() {
    }

    public Employees(String id, String name, double bouds) {
        this.id = id;
        this.name = name;
        this.bouds = bouds;
    }

    public void work(){
        System.out.println("员工在工作");
    }
    public void eat(){
        System.out.println("吃米饭");
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return bouds
     */
    public double getBouds() {
        return bouds;
    }

    /**
     * 设置
     * @param bouds
     */
    public void setBouds(double bouds) {
        this.bouds = bouds;
    }

    public String toString() {
        return "Person{id = " + id + ", name = " + name + ", bouds = " + bouds + "}";
    }
}
