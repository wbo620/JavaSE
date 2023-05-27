import java.util.Scanner;

public class face4 {
    /*
    * 面试题4:
    * 在一个从左到右,从上到下都递增顺序排列的二维数组中,查找数字*/
    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 8, 9},
                                  {2, 4, 9, 12},
                                  {4, 7, 10, 13},
                                  {6, 8, 11, 15}};
        boolean flag = false;
        System.out.println("请输入要查找的数字");
        Scanner sc=new Scanner(System.in);
        int find = sc.nextInt();
        //记录右上角的索引
        int row = 0;
        int col = arr.length - 1;
        //如果索引越界循环停止
            while (row<arr.length&&col>=0) {
                //如果要查找的数跟当前所存的数相同,跳出循环
                if (arr[row][col] == find) {
                    flag=true;
                    break;
                    //如果右上角的数大于要查找的数字,说明这一 列 都要大于这个数,舍弃该列,col向前走
                } else if (arr[row][col] > find) {
                    col--;
                    //如果右上角的数小于要查找的数字,说明这一 行 都要小于这个数,舍弃该行,row向下走
                } else {
                    row++;
                }

            }
        System.out.println(flag);
    }
}
