public class face5 {
/*面试题5
* 把一个字符串里的空格都变成%20*/
    public static void main(String[] args) {
        String str="We are happy!";
        //1.时间复杂度o(n)
        char[] ch = str.toCharArray();
        int count=0;//记录空格的个数
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i]==' ')count++;
        }//创建新数组,新数组长度是原来数组长度+2x空格的个数
        char []newch=new char[ch.length+2*count];
        //p1指向新数组的最后索引
        //p2指向旧数组的最后索引
        int p1,p2;
        p1=newch.length-1;
        p2=ch.length-1;
        //保证索引不越界,倒着开始遍历数组
        while (p1>=0&&p2>=0){
            //如果发现空格,则新数组的前三个被赋值
            if (ch[p2]==' '){
                newch[p1--]='0';
                newch[p1--]='2';
                newch[p1]='%';
            }else {
                newch[p1]=ch[p2];
            }
            p1--;
            p2--;
        }
        for (int i = 0; i < newch.length; i++) {
            System.out.print(newch[i]+", ");
        }

    }
}
