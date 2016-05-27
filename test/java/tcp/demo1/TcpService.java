package tcp.demo1;

/**
 * Created by simpletour_java on 2015/6/26.
 */

import javax.print.attribute.standard.MediaSize;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * 定义端点的接收数据并打印在控制台上
 * 1，建立服务端的Socket服务。serverSocket（）；并监听一个端口
 *
 * 2，获取连接过来的客户端对象。 通过ServerSocket的accept方法。所以这个方法时阻塞时式的
 *
 * 3，如果客户端发过啦主句，那么服务店端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据
 *
 * 4，关闭服务端socket（可选）。
 *
 */

public class TcpService {
    public  static void main(String[]args) throws Exception{
        //建立服务端Socket服务，并监听一个端口
        ServerSocket serverSocket = new ServerSocket(10003);

        //通过accept方法获取连接过来的客户端对象
        Socket socket = serverSocket.accept();

        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + ".........connected");
        //获取客户端发送过来的数据，要么使用客户端对象的读取流来读取流来读取数据
        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);

        System.out.println(new String(buf,0,length));

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("收到，你好！".getBytes());

        serverSocket.close();

        socket.close();
    }
}
