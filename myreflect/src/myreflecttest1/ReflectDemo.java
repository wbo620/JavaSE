package myreflecttest1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class ReflectDemo {
    //对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student s=new Student("张三","男",34,"北京");
        Techer t=new Techer("李四",10000);

        saveObject(t);
        saveObject(s);

    }

    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        //关联字节码文件
        Class clazz = obj.getClass();

        //创建io流,把数据写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/a.txt"));
        //获取所有成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        //获取成员变量的值
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            //得到每个成员变量的名字
            String name = declaredField.getName();
            //得到每个成员变量所对应的值
            Object value = declaredField.get(obj);
            System.out.println(name + "=" + value);
            //写出到文件
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
