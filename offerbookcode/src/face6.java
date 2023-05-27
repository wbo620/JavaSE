import java.util.Stack;

public class face6 {
    //从头到尾打印链表
    /*输入一个链表的头结点,从尾到头反过来打印出每个节点的值*/
    //单链表结构
    public static class Node {
         int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;

        public LinkedList() {
            this.head = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
    }

    //用栈实现
    public static void stackToPrint(Node head) {

        Stack<Integer> s1=new Stack<Integer>();
        Node p=head;
        //将链表中的节点压进栈中
        while (p!=null) {
            s1.push(p.data);
            p=p.next;

        }
        //打印弹出
        while (!s1.isEmpty()) {
            System.out.println(s1.pop()+"");
        }

    }

    //递归实现
    public static void fibPrint(Node head){
        //头结点,或首元结点为空跳出递归
        if (head!=null){
            if(head.next!=null){
                //递归调用
                fibPrint(head.next);
            }
        }
        System.out.println(head.data);
    }
    public static void main(String[] args) {
    LinkedList l=new LinkedList();
    l.add(1);
    l.add(2);
    l.add(3);
    l.add(4);

    //stackToPrint(l.head);
        fibPrint(l.head);



    }
}
