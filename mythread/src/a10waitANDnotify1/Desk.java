package a10waitANDnotify1;

public class Desk {
    //总个数
    public static int count=10;
    //是否有面条,0表示没有,1表示有
    public static int foodflag=0;
    //锁对象
    public static Object lock=new Object();
}
