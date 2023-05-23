package a07test3;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {


        //创建对象,绑定端口
        ServerSocket ss=new ServerSocket(10000);

        //等待客户端大发送数据
        Socket socket = ss.accept();

        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        String name = UUID.randomUUID().toString().replace("-", "");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(name+".jpg"));
        int len;
        byte[] bytes=new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        OutputStream os =socket.getOutputStream();
        os.write("上传成功".getBytes());

        socket.close();
        ss.close();
    }
}
