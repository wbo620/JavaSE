package filetest;

import java.io.File;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FileTest6 {
    //需求:查询某个文件夹里所有类型文件的个数
    public static void main(String[] args) {
       // File src=new File("/Users/hallen/java_code/FileDemo/aaa");
        File src=new File("/Users/hallen/Downloads");
        //第一种
        HashMap<String,Integer> hm=new HashMap<>();
        getCount(src,hm);
        //第二种
       // HashMap<String,Integer> hm= getCount1(src);

        //打印map集合
        hm.forEach((key,valule)-> System.out.println(key+"="+valule+"个"));

    }


    //两种解决办法
    //一.
    public static void getCount(File src, HashMap<String, Integer> hm) {
        //1.进入src文件夹
        File[] files = src.listFiles();
        //非空判断
        if (files!=null) {
            //进入src文件夹
            for (File file : files) {
                //2.判断:如果是文件,添加到map集合中
                if (file.isFile()){
                    String name = file.getName();
                    //将分割后的数据转成数组
                    String[] arr = name.split("\\.");//正则表达式
                    //如果数组长度大于2,则说明该文件有后缀名
                    if (arr.length>=2) {
                        //获取数组最后一个元素,即后缀名(细节->并不是直接用split("\\.")[1]当做后缀名,这样是错的)
                        String s = arr[arr.length-1];
                        if (!hm.containsKey(s)) {
                            //如果集合中没有出现过,添加进去,次数为1
                            hm.put(s, 1);
                        } else {
                            //出现过,在此基础上+1
                            hm.put(s, hm.get(s) + 1);
                        }
                    }
                    //判断:如果是文件夹,递归调用,进入文件夹,继续进行判断
                }else {
                    getCount(file, hm);
                }
            }
        }
    }
    //二.
    public static HashMap<String, Integer> getCount1(File src) {
        //1.进入src文件夹
        File[] files = src.listFiles();
        HashMap<String,Integer> hm=new HashMap<>();
        //非空判断
        if (files!=null) {
            //进入src文件夹
            for (File file : files) {
                //2.判断:如果是文件,添加到map集合中
                if (file.isFile()){
                    String name = file.getName();
                    //将分割后的数据转成数组
                    String[] arr = name.split("\\.");
                    //如果数组长度大于2,则说明该文件有后缀名
                    if (arr.length>=2) {
                        //获取数组最后一个元素,即后缀名
                        String s = arr[arr.length-1];
                        if (!hm.containsKey(s)) {
                            //如果集合中没有出现过,添加进去,次数为1
                            hm.put(s, 1);
                        } else {
                            //出现过,在此基础上+1
                            hm.put(s, hm.get(s) + 1);
                        }
                    }
                    //判断:如果是文件夹,递归调用,进入文件夹,继续进行判断
                }else {
                    //声明一个子map集合,用来暂时存放数据
                    HashMap<String,Integer> sonHm=getCount1(file);
                    Set<Map.Entry<String, Integer>> entries = sonHm.entrySet();
                    //遍历集合
                    for (Map.Entry<String, Integer> entry : entries) {
                        String name = entry.getKey();
                        Integer count = entry.getValue();
                        //如果大集合已经出现过后缀名
                        if (hm.containsKey(name)) {
                            //获取原来出现的次数
                            Integer i = hm.get(name);
                            //加上新的次数
                            count+=i;
                            //再添加到大集合中
                            hm.put(name,count);
                        }else {
                            //如果是新的后缀名
                            //则直接原封不动全部添加进去
                            hm.put(name,count);
                        }
                    }
                }
            }
        }
        return hm;
    }

}
