package myreflect2;

import javax.xml.transform.Source;
import java.awt.*;
import java.lang.reflect.Field;

public class RefectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

            /*Class类中用于获取成员变量的方法
        Field[]getFields():返回所有公共成员变量对象的数组
        Field[]getDeclaredFields():返回所有成员变量对象的数组
        Field getField(String name):返回单个公共成员变量对象
        Field getDeclaredField(String name):返▣单个成员变量对象
                Field类中用于创建对象的方法
        void set(Object obj,Object value):赋值
        Object get(Object obj))获取值。*/

        Class clazz = Class.forName("myreflect2.Students");

        Field[] fields = clazz.getFields();
        //获取public修饰的成员变量
        for (Field field : fields) {
            System.out.println(field);
        }
        //2.获取所有的成员变量
        /*Field[] fields =clazz.getDeclaredFields();
             for (Field field: fields) {
                 System.out.println(field);
             }*/
        //获取单个的成员变量
        Field name= clazz.getDeclaredField("name");
        System.out.println(name);
        //获取权限修饰符
        int modifiers= name.getModifiers();
        System.out.println(modifiers);
        //获取成员变量的名字
        String n =name.getName();
        System.out.println(n);
        //获取成员变量的数据类型
        Class<?> type =name.getType();
        System.out.println(type);
        //获取成员变量记录的值
        name.setAccessible(true);
        Students s =new Students("zhangsan", 23, "男");
        Object value = name.get(s);
        System.out.println(value);

        //利用反射修改对象里的值
        name.set(s,"lisi");
        System.out.println(s);




    }
}
