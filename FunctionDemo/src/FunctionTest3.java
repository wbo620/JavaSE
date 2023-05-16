import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionTest3 {
    public static void main(String[] args) {
        /* 练习3：创建集合添加学生对象，学生对象属性：name,age
           把姓名和年龄拼接成：张三-23的字符串，并放到数组当中（使用方法引用完成)*/
        ArrayList<Student> list=new ArrayList<Student>();
        list.add(new Student("张三",23));
        list.add(new Student("李四",24));
        list.add(new Student("王五",25));

        //lambda方式
        //在Student类中新添加了一个getNameAge的方法
        String[] arr1 = list.stream().map(Student::getNameAge).toArray(String[]::new);
        System.out.println(Arrays.toString(arr1));
        //匿名内部类的方式
        String[] arr2 = list.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                String s = student.getName() + "-" + student.getAge();
                return s;
            }
        }).toArray(String[]::new);
        System.out.println(Arrays.toString(arr2));

    }
}
