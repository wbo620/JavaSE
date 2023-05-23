package a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMassage {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds=new DatagramSocket(10086);

        byte[]bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);

        while (true) {

            ds.receive(dp);
            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            String name = dp.getAddress().getHostName();
            int port = dp.getPort();


            System.out.println("从ip为:"+ip+"端口号为:"+port+"主机名"+name);
            System.out.println("接收到数据:"+new String(data,0,len));
        }


    }
}
