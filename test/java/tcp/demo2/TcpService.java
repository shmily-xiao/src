package tcp.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by simpletour_java on 2015/7/1.
 */
public class TcpService{
    public static void main(String[] args) throws Exception{

        System.out.println("Service....");
        ServerSocket ss = new ServerSocket(10004);
        Socket s = ss.accept();//停顿

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....is connect..");
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));

        OutputStream out = s.getOutputStream();
        out.write("我收到,hello".getBytes());
        s.close();
        ss.close();
    }
}
