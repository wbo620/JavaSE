package user;

import java.util.Objects;

public class User {
    private String name;
    private String password;
    private String ID;
    private String phoneNumber;

    public User() {
    }

    public User(String name, String password, String ID, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return name
     */
    public  String getName() {
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(ID, user.ID) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, ID, phoneNumber);
    }

    public String toString() {
        return "User{name = " + name + ", password = " + password + ", ID = " + ID + ", phoneNumber = " + phoneNumber + "}";
    }

}
