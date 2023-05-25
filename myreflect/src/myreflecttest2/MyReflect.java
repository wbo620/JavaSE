package myreflecttest2;

import javax.sql.rowset.FilteredRowSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflect {
    //反射可以跟配置文件结合的方式，动态的创建对象，并调用方法
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取配置文件中的信息
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);

        //获取全类名和方法名

        String className =(String) prop.get("classname");
        String methodName =(String) prop.get("method");

        System.out.println(className);
        System.out.println(methodName);

        //利用反射创建对象并运行方法

        Class clazz=Class.forName( className);


        //获取构造方法
        Constructor con = clazz.getDeclaredConstructor();

        Object o = con.newInstance();

        //获取成员方法
        Method method1 = clazz.getDeclaredMethod( methodName);
        method1.setAccessible(true);
        method1.invoke(o);


    }



}
