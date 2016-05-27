package tcp.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by simpletour_java on 2015/7/1.
 */
public class TcpClient {
    public static void main(String[] args) throws Exception{
        System.out.println("Client....");
        Socket s = new Socket("192.168.2.57",10004);

        OutputStream out = s.getOutputStream();
        out.write("服务端，你好".getBytes());

        InputStream in = s.getInputStream();
        byte[] buf = new byte[1204];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));

        s.close();
    }
}
