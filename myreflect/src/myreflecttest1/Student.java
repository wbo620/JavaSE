package myreflecttest1;

public class Student {
    private String name;
    private String gender;

    private  int age;

    private String adress;

    public Student() {
    }

    public Student(String name, String gender, int age, String adress) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.adress = adress;
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
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 设置
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String toString() {
        return "Student{name = " + name + ", gender = " + gender + ", age = " + age + ", adress = " + adress + "}";
    }
}
