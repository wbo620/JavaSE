package myobjectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    /*
    需求：
        利用反序列化流/对象操作输入流，把文件中中的对象读到程序当中
    构造方法：
        public ObjectInputStream(InputStream out)
            把基本流变成高级流
    成员方法：
        把序列化到本地文件中的对象，读取到程序中来
        public Object readobject()
*/

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/s.txt"));

        Student o = (Student)ois.readObject();

        System.out.println(o);

        ois.close();


    }



}
