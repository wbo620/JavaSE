package a01threadpoll1;

public class MyThreadpoll1 {
    public static void main(String[] args) {
        //获取idea能调用cpu的最大线程数
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}
