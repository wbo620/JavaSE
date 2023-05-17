package code.test;

//求一个字符串最后一个单词的长度
public class Test06 {
    public static void main(String[] args) {
        String s="Hello World!!!";
        int count=strEndLength(s);
        if (count!=0) {
            System.out.println("字符串最后一个单词长度为:"+count);
        }else System.out.println("空字符串");

    }
    public static int strEndLength(String str){
        //先把字符串变成字符数组再进行判断
        char[]arr=str.toCharArray();
        int count=0;
        //倒着遍历数组
        if (arr.length!=0) {
            for (int i = arr.length-1; i >=0; i--) {
                if ((arr[i]>='a'&&arr[i]<='z')||(arr[i]>='A'&&arr[i]<='Z')){
                    count++;
                }
                if (arr[i]==' '){
                    break;
                }

            }
        }
            return count;
    }
}
