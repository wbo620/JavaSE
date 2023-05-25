package myreflect3;

import javax.xml.transform.Source;
import java.lang.module.ModuleFinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefectDemo {
    /*

        Class类中用于获取成员方法的方法
             Method[]getMethods():返回所有公共成员方法对象的数组，包括继承的
             Method[]getDeclaredMethods():返回所有成员方法对象的数组，不包括继承的
             Method getMethod(String name,Class<-?>...parameterTypes):返回单个公共成员方法对象
             Method getDeclaredMethod(String name,Class<?>…parameterTypes)):返回单个成员方法对象
        Method类中用于创建对象的方法
            Object invoke(Object obj,Object..args):运行方法
            参数一：用obj对象调用该方法
            参数二：调用方法的传递的参数（如果没有就不写)
            返回值：方法的返回值（如果没有就不写）*/
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("myreflect3.Student");

       /* //获取公共的成员方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取全部的成员方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }*/

        //获取指定的单个成员方法
        Method m = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(m);

        //获取方法的修饰符
        int modifiers = m.getModifiers();
        System.out.println(modifiers);

        //获取方法的名字
        String name = m.getName();
        System.out.println(name);

        //获取方法的形参
        Class[] parameterTypes = m.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        //获取方法抛出的异常
        Class[] exceptionTypes = m.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        //方法运行
        /*Method类中用于创建对象的方法
        Object invoke(Object obj,Object...args):运行方法
        参数一：用obj对象调用该方法
        参数二：调用方法的传递的参数（如果没有就不写）
        返回值：方法的返回值（如果没有就不写）*/
        Student s= new Student();
        m.setAccessible(true);
        //参数一s:表示方法的调用者
        //参数二"汉堡包"：表示在调用方法的时候传递的实际参数
        Object invoke = m.invoke(s,"汉堡");
        System.out.println(invoke);



    }
}
