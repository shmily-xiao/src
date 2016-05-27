package chat.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by simpletour_java on 2015/6/12.
 */
public class Send implements Runnable{

    private DatagramSocket ds;
    public  Send(DatagramSocket ds){
        this.ds = ds;
    }
    public void run(){
        try{
            BufferedReader bufr =  new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while((line=bufr.readLine())!=null){
                if("886".equals(line)){
                    break;
                }
                byte[] buf = line.getBytes();

                DatagramPacket dp =
                        new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.2.255"),10001);
                ds.send(dp);
            }
        }catch(Exception e){
            throw new RuntimeException("发送端失败");
        }

    }
}
