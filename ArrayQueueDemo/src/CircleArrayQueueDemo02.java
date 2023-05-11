import java.util.Scanner;
//用数组实现环形队列
public class CircleArrayQueueDemo02 {
    public static void main(String[] args) {
        CircleArrayQeue queue=new CircleArrayQeue(4);//给出4个数组,其最大数组为3个(可用)
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a:显示队列");
            System.out.println("b:添加数据");
            System.out.println("c:取出数据");
            System.out.println("d:查看头部");
            System.out.println("e:退出程序");
            key = sc.next().charAt(0);// 接收一个字符
            switch (key) {
                case 'a': {
                    System.out.println("队列元素为：");
                    queue.showQueue();
                    break;
                }
                case 'b': {
                    System.out.println("输入一个数");
                    int data = sc.nextInt();
                    queue.addQueue(data);
                    break;
                }
                case 'c': {
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据为：" + res);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                }
                case 'd': {
                    try {
                        int res = queue.headQueue();
                        System.out.println("头部的数据为：" + res);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                }
                case 'e': {
                    System.out.println("程序退出");
                    loop = false;
                    break;
                }
                default:
                    break;
            }

        }
    }
    static class CircleArrayQeue {
        private int maxSize;
        private int front;//指向队列头部
        private int rear;//指向队列最后一个元素的后一个的位置
        private int[] arr;

        // 创建队列构造器
        public  CircleArrayQeue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];

        }

        // 判断队列是否为空
        public boolean isEmpty() {
            return front == rear;//指针指向同一个位置表示队列为空
        }

        //判断是否存满
        public boolean isFull(){
            return (rear+1)%maxSize==front;//有效个数,如果rear指向了最后一个元素的后一个位置,就说明队列存满
        }
        //添加数据
        public void addQueue(int data){
            if(isFull()){
                System.out.println("数据已满，不能存入");
                return;
            }
            //环形队列，考虑指针越界，进行%运算以构造环形指针
            arr[rear]=data;
            rear= (rear+1)%maxSize;

        }

        //弹出数据
        public int getQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列为空，删除失败");
            }
            //环形队列，考虑指针越界，进行%运算以构造环形指针
            //front指向队列第一个元素
            //1.p存放当前需要返回的数据
            //2.front往后走,考虑%运算
            //3.将临时变量存放的值返回
            int p=arr[front];
            front=(front+1)%maxSize;//循环指针
            return p;

        }
        //显示队列
        public void showQueue(){
            if (isEmpty()){
                System.out.println("队列为空");
             }
            //1.从front开始遍历,打印size()个长度
            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d] =%d  ", i%maxSize, arr[i%maxSize]);//取模才是当前所指的元素
            }
            System.out.println();
        }
        //返回队列有效长度
        public  int size(){
            return (rear+maxSize-front)%maxSize;
        }
        //显示队列头
        public int headQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列为空");
            }
            return arr[front];
        }
    }

}
