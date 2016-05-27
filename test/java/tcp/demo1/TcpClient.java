package tcp.demo1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by simpletour_java on 2015/6/26.
 */

public class TcpClient {
    public static void main(String[] args) throws Exception{
        //创建客户端的socket服务，指定目的主机和端口
        Socket socket = new Socket("192.168.2.57",10003);

        //为了发送数据，应该获取socket流中的输出流
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("hello word".getBytes());

        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];

        int len = inputStream.read(buf);

        System.out.println(new String(buf,0,len));

        socket.close();
    }
}
