package wubo;

public class prople {
    private String name;
    private String no;
    public prople() {
    }
    public prople(String name, String no) {
        this.name = name;
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String toString() {
        return "prople{name = " + name + ", no = " + no + "}";
    }
}
