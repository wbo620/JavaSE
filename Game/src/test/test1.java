package test;

import java.util.Random;

public class test1 {

    public static void main(String[] args) {
        int tempArr[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        //打乱数组
        for (int i = 0; i < tempArr.length; i++) {
            int index=r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        int [][]arr=new int[4][4];
        //将一维数组的数字放到二维数组中
        //方法一.遍历一维数组,将一维数组里的数放到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            arr[i/4][i%4]=tempArr[i];
        }

//        //方法二.遍历二维数组,将一维数组放到二维数组中
//        int index=0;//记录一维数组的索引
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j]=tempArr[index++];
//            }
//        }

        //打印一维数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
