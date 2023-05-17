package a01students;

public class Student {
    private String id;
    private String name;
    private int age;
    private String homeAddress;


    public Student() {
    }

    public Student(String id, String name, int age, String homeAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.homeAddress = homeAddress;
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + ", homeAddress = " + homeAddress + "}";
    }
}
