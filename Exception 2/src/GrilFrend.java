public class GrilFrend {
    private String name;
    private int age;

    public GrilFrend() {
    }

    public GrilFrend(String name, int age) {
        this.name = name;
        this.age = age;
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
        if (name.length()<3||name.length()>18){
            throw new NameFormatExample(name+"姓名长度不符合要求");
        }
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
        if (age<18||age>40){
            throw new AgeOutBoundsException(age+"年龄超出范围");
        }
        this.age = age;
    }

    public String toString() {
        return "GrilFrend{name = " + name + ", age = " + age + "}";
    }
}
