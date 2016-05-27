package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.zip.DataFormatException;

/**
 * Created by simpletour_java on 2015/6/12.
 * 将数据通过udp的传输方式。将一段文字数据发送出去
 * 1，建立updsocket服务；
 * 2，提供数据，并将数据封装到数据包中；
 * 3，通过socket服务的发送功能，将数据包发出去；
 * 4，关闭
 */
public class Udpsend {
    public static void main(String[] args) throws Exception{
        //1
        DatagramSocket ds = new DatagramSocket(8888);

        //2
//        byte[] buf = "udp ge men lai le".getBytes();
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while((line = bufr.readLine())!= null){
            if("886".equals(line))
                break;
            byte[] buf = line.getBytes();

            DatagramPacket dp =
                    new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.2.255"),10000);

            //3
            ds.send(dp);
        }

        //4
        ds.close();
    }

}
