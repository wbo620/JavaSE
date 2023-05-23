package a01netaddress1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInteAdressDemo1 {
    /*static InetAddress getByName(String host)确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
    String getHostName()获取此工P地址的主机名
    String getHostAddress() 返回文本显示中的工P地址字符串*/

    public static void main(String[] args) throws UnknownHostException {

        //获取inetAdress对象
        InetAddress address = InetAddress.getByName("172.20.10.3");
        System.out.println(address);

        String name = address.getHostName();
        System.out.println(name);

        String ip = address.getHostAddress();
        System.out.println(ip);

    }

}
