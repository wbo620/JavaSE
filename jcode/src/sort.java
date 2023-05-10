import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

//冒泡排序和二分查找
public class sort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个数字");
        for (int i = 0; i < arr.length; i++) {

            arr[i] = sc.nextInt();
        }
        System.out.println("----------");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "--");
        }
        System.out.println();
        System.out.println("请输入要查找的数字");
        int c = sc.nextInt();
        int index = sort(arr, c);
        if (index == -1) {
            System.out.println("没有该数字");
        } else {
            System.out.println("所查找数字索引为：" + index);
        }
    }

    public static int sort(int arr[], int c) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (c > arr[mid]) {
                left = mid + 1;

            } else if (c < arr[mid]) {
                right = mid - 1;

            } else {
                return mid;
            }
        }

        return -1;
    }
}
