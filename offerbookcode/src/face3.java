public class face3 {

    /*面试题3:
    * 在一个长度为n的数组中的所有数字0-n-1中,找出数组中任意重复的数字*/
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};

        //第一个循环是为了排序,将索引与该索引所对应的数字
       loop: for (int i = 0; i < arr.length; i++) {
            //如果当前索引上的数字跟索引不匹配
           // 就拿当前的数字arr[i] 跟 当前数字索引位置的数arr[temp]交换位置交换位置
            while (arr[i]!=i) {
                int temp= arr[i];
                arr[i]=arr[temp];
                arr[temp]=temp;

                if (arr[i]==arr[temp]){
                    System.out.println(arr[i]);
                   break loop;
                }

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }


    }

}
