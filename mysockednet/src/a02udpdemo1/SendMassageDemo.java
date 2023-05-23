package a02udpdemo1;

import java.io.IOException;
import java.net.*;

public class SendMassageDemo {
    public static void main(String[] args) throws IOException {

        //发送数据
        //1.创建DatagramSocket对象（快递公司）
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用
        DatagramSocket ds=new DatagramSocket();
        //2.打包数据
        //要发送的数据
        String str="姬霓太美";
        byte[] bytes = str.getBytes();
        //要发送的ip
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        //要发送的端口号
        int port=10000;

        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,ip,port);

        //发送数据
        ds.send(dp);

        //关流
        ds.close();


    }
}
