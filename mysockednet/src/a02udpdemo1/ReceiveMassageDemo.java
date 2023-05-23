package a02udpdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(10000);

        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);

        ds.receive(dp);


        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("从ip为:"+address+"端口号为:"+port);
        System.out.println("接收到数据:"+new String(data,0,len));
    }
}
