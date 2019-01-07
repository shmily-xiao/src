package java.test;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Test {
    public static void main(String[] args) throws Exception{
        InetAddress i = InetAddress.getLocalHost();
        System.out.println(i.toString());
        System.out.println("address:"+i.getHostAddress());
        System.out.println("name:" + i.getHostName());


        InetAddress ia = InetAddress.getByName("www.google.com.hk");
        System.out.println(ia.toString());
        System.out.println("address:"+ia.getHostAddress());
        System.out.println("name:" + ia.getHostName());

        int distance =0;
        int val = -1;
        for (;val !=0;val <<=1){
            System.out.println("val="+val);
            distance ++;
        }
        System.out.println("val:"+val);
        System.out.println(distance);

        double ii = 0.0/0.0;
        System.out.println(ii);
        System.out.println(ii==0);
    }
}
