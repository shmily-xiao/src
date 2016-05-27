package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//用于接收和处理数据
/**
 * 1.定义udpsocket服务.通常会监听一个端口。其实就是给这个接收网络应用程序定义数据标示。
 * 方便与明确哪些数据过来该应用程序可以处理。
 * 2.定义一个数据包，因为要储存接收到的字节数据。
 * 因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
 * 3，通过socket服务的receive刚发将受到的数据存入已定义好的数据包中。
 * 4，听过数据包对象的特有功能，将这些不同的数据取出。打印在控制台上。
 * 5，关闭资源。
 * */

public class UdpReceive {

    public static void main(String[] args) throws Exception{


        //1
        DatagramSocket ds = new DatagramSocket(10000);

        while(true) {
            //2一次性接收的数据大小1024字节
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            //3
            ds.receive(dp);

            //4
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            int port = dp.getPort();
            System.out.println(ip + "::" + data + "::" + port);
        }
        //5
//        ds.close();


    }
}
