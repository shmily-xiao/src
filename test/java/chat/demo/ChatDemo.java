package chat.demo;

import java.net.DatagramSocket;


/**
 * Created by simpletour_java on 2015/6/12.
 */
public class ChatDemo{
    public static void main(String[] args) throws Exception{

        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receiveSocket = new DatagramSocket(10001);

        new Thread(new Send(sendSocket)).start();
        new Thread(new Receive(receiveSocket)).start();

    }
}
