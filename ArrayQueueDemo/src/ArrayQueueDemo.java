import java.util.Scanner;
//用数组实现队列（固定版本）

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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

    static class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        // 创建队列构造器
        public  ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;// 指向头部指针
            rear = -1;// 指向尾部指针
        }

        // 判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }

        // 判断队列是否存满
        public boolean isFull() {
            return rear == maxSize-1 ;
        }

        // 添加数据
        public void addQueue(int date) {
            if (isFull()) {
                System.out.println("队列已满，不能存入数据");
                return;
            }
            ++rear;// 因为最开始指向-1
            arr[rear] = date;
        }

        // 删除数据
        public int getQueue() {
            if (isEmpty()) {
                // 如果为空，指针指向的就是-1索引，抛出指针异常
                throw new RuntimeException("队列中无数据，删除失败");
            }
            front++;
            return arr[front];
        }

        // 显示队列
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列无数据，不能打印");
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d  ", i, arr[i]);
            }
            System.out.println();
        }

        // 显示队列头数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return arr[front + 1];// +1是因为开始front指向-1；
        }
    }

}
