package a08test4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable{
    Socket socket;
    public  MyRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
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


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //释放资源
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
