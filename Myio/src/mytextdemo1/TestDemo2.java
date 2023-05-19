package mytextdemo1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.*;

public class TestDemo2 {
    public static void main(String[] args) {

        //爬取网站数据,记录姓,男女的名,并写入到文件
        //1.定义变量记录网址
        String familyNameNet = HttpUtil.get("https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0");
        String boyNameNet = HttpUtil.get("http://www.haoming8.cn/baobao/10881.html");
        String girlNameNet = HttpUtil.get("http://www.haoming8.cn/baobao/7641.html");

        //2.按照正则表达式爬取数据
        List<String> familyNametTempList = ReUtil.findAll("(.{4})(，|。)", familyNameNet, 1);
        List<String> boyNameTempList = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(、|。)", boyNameNet, 1);
        List<String> girlNameTempList = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})( )", girlNameNet, 0);


        //3.处理数据
        // 按要求截取,把正确的格式存放在集合中
        //姓,把每一个姓氏拆开存放到集合中
        ArrayList<String> familyNameList = new ArrayList<String>();
        for (String str : familyNametTempList) {
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
        //4.生成数据(唯一)
        //格式:姓名-性别-年龄,再打乱集合
        ArrayList<String> infor = getInfor(familyNameList, boyNameList, girlNameList, 70, 50);
        Collections.shuffle(infor);
        System.out.println(infor);
        //5.写入文件
        //糊涂包的相对路径,不是相对于当前项目而言,而是相对class文件,再out文件夹
        FileUtil.writeLines(infor,"TestDemo2随机姓名.txt","UTF-8");


    }
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

}
