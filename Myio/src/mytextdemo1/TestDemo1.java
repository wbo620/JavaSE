package mytextdemo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        //1.定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";
        //2.爬取网页的数据,存放在字符串中
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);
        //3.正则表达式,截取自己想要的部分,放入临时的集合中
        ArrayList<String> familyNameTempList = getData(familyNameStr, "(.{4})(，|。)", 1);
        //System.out.println(familyNameTempList);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        //System.out.println(boyNameTempList);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "([\\u4E00-\\u9FA5]{2})( )", 0);
        //System.out.println(girlNameTempList);
        //4.处理数据
        // 按要求截取,把正确的格式存放在集合中
        //姓,把每一个姓氏拆开存放到集合中
        ArrayList<String> familyNameList = new ArrayList<String>();
        for (String str : familyNameTempList) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }
        //男生名
        ArrayList<String> boyNameList = new ArrayList<String>();
        for (String str : boyNameTempList) {
            if (!boyNameList.contains(str))
                boyNameList.add(str);
        }
        //女生名
        ArrayList<String> girlNameList = new ArrayList<String>();
        for (String str : girlNameTempList) {
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                girlNameList.add(arr[i]);
            }

        }
        /*System.out.println(familyNameList);
        System.out.println(boyNameList);
        System.out.println(girlNameList);*/
        //5.生成数据(唯一)
        //格式:姓名-性别-年龄,再打乱集合
        ArrayList<String> infor = getInfor(familyNameList, boyNameList, girlNameList, 70, 50);
        Collections.shuffle(infor);
        System.out.println(infor);

        //6.写出数据到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/随机姓名.txt"));
        for (String name : infor) {
            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }

    //按格式生成数据
    public static ArrayList<String> getInfor(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCouunt, int girlCount) {
        HashSet<String> boys = new HashSet<>();
        while (true) {
            //集合中里的数据个数已满足就停止
            if (boys.size() == boyCouunt) {
                break;
            }
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            //随机后,把两个集合第一个元素拼接添加到新集合中
            boys.add(familyNameList.get(0) + boyNameList.get(0));
        }
        HashSet<String> girls = new HashSet<>();
        while (true) {
            if (girls.size() == girlCount) {
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girls.add(familyNameList.get(0) + girlNameList.get(0));
        }
        //创建一个存放指定格式的集合
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        //添加男孩
        //年龄在18-27
        for (String boyName : boys) {
            //括号里=(27-18+1)=10
            //外面=+减去的18
            int age = r.nextInt(10) + 18;
            list.add(boyName + "-男-" + age);
        }
        //添加女孩
        //18-25岁
        for (String girlName : girls) {
            int age = r.nextInt(8) + 18;
            list.add(girlName + "-女-" + age);
        }
        return list;

    }

    //按照正则表达式获取想要的数据的方法
    public static ArrayList<String> getData(String str, String regrx, int index) {
        //1.创建存放的集合
        ArrayList<String> list = new ArrayList<String>();
        //2.按照正则表达式的规则,去获取数据
        Pattern pattern = Pattern.compile(regrx);
        //3.按照pattern的规则,到str中获取数据,得到文本匹配器对象
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(index);

            list.add(group);
        }
        return list;
    }

    //爬取数据的方法
    public static String webCrawler(String net) throws IOException {
        //1.创建一个集合存放爬取的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个网址对象
        URL url = new URL(net);
        //3.连接上这个网址
        URLConnection coon = url.openConnection();
        //4.获取数据,用转换流把字节流转换为字符流
        InputStreamReader isr = new InputStreamReader(coon.getInputStream());
        //5.读取数据,添加到集合中
        int ch;
        while ((ch = isr.read()) != -1) {

            sb.append((char) ch);
        }

        isr.close();

        return sb.toString();

    }
}
