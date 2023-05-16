import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FunctionText2 {
    public static void main(String[] args) {
     /*   练习2：创建集合添加学生对象，学生对象属性：name,age
        只获取姓名并放到数组当中（使用方法引用完成）*/
        ArrayList<Student> list=new ArrayList<Student>();
        list.add(new Student("张三",23));
        list.add(new Student("李四",24));
        list.add(new Student("王五",25));

        String[] arr = list.stream().map(Student::getName).toArray(String[]::new);

        System.out.println(Arrays.toString(arr));
    }
}
