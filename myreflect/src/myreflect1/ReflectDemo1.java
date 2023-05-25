package myreflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
     /*   Class类中用于获取构造方法的方法
        		Constructor<?>[]getConstructors):返回所有公共构造方法对象的数组
        		Constructor<?>[]getDeclaredConstructors():返回所有构造方法对象的数组
        		Constructor<T>getConstructor(Class<?>…parameterTypes):返回单个公共构造方法对象
        		Constructor<T>getDeclaredConstructor(Class<?>…parameterTypes):返回单个构造方法对象

        Constructor类中用于创建对象的方法
            T newlnstance(Object...initargs):根据指定的构造方法创建对象
            setAccessible(boolean flag):设置为true,表示取消访问检查*/

        //获取字节码对象
        Class clazz = Class.forName("myreflect1.Students");



        //获取public修饰的构造方法
        //Constructor[] cons1 = clazz.getConstructors();
        //for (Constructor con : cons1) {
        //    System.out.println(con);
        //}

        //获取全部的构造方法
       /* Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);
        }*/

        //获取参数为字符串为参数的的构造方法
       /* Constructor con3 = clazz.getDeclaredConstructor(String.class);
        System.out.println(con3);*/

        //获取参数为字符串和整形为参数的的构造方法
        Constructor con4 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con4);

        //临时取消权限修饰
        con4.setAccessible(true);
        Students stu = (Students)con4.newInstance("张安", 23);
        System.out.println(stu);

        int modifiers = con4.getModifiers();
        System.out.println(modifiers);

        //获取里面的参数
        Parameter[] p = con4.getParameters();
        for (Parameter parameter : p) {
            System.out.println(parameter);
        }

    }

}
