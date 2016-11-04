package com.echo;

import javafx.scene.control.RadioMenuItem;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/11/3.
 *
 * socket 就是一进一出 client.getInputStream() 和 client.getOutputStream()
 *
 * 第几次，是否通过认证，客户端随机数，服务端随机数，是否结束回话，内容
 *
 * 比如：
 * 1,false,256,456,false,abcd
 *
 *
 */
public class EchoClient {
    public static void main(String[] args) throws Exception{
        int TIMES = 0;
        int IS_SUCCESS = 1;
        int CLIENT_RANDOM = 2;
        int SERVER_RANDOM = 3;
        int IS_FINISHED = 4;
        int CONTENT = 5;
        int LENGTH = 6;

        int clientRand = 0;
        // 建立连接
        Socket client = new Socket("localhost",6789);

        PrintWriter pw1 = new PrintWriter(client.getOutputStream());

        Random random2 = new Random();
        clientRand = random2.nextInt(1000)+1;

        String msg2 = "1,false,"+clientRand+",0,false, 你好";

        // 利用socket在这个通道里面发送内容
        pw1.println(msg2);
        // 必须要flush才会发出去
        pw1.flush();

        while(true){

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String serverMsg = br.readLine();
            System.out.println(serverMsg);
            if (serverMsg==null || serverMsg.isEmpty()){
                PrintWriter pw = new PrintWriter(client.getOutputStream());

                Random random = new Random();
                clientRand = random.nextInt(1000)+1;

                String msg = "1,false,"+clientRand+",0,false, 你好";

                // 利用socket在这个通道里面发送内容
                pw.println(msg);
                // 必须要flush才会发出去
                pw.flush();
            }else {
                String[] serverArguments = serverMsg.split(",");
                if ("true".equals(serverArguments[IS_FINISHED])) break;
                if (serverArguments.length != LENGTH ) break;
                if ("true".equals(serverArguments[IS_SUCCESS])){
                    PrintWriter pw = new PrintWriter(client.getOutputStream());

                    String clientMsg = "这是握手后的第一句话,然后拜拜！";
                    String msg = serverArguments[TIMES] + "," + serverArguments[IS_SUCCESS] + ","
                            +serverArguments[CLIENT_RANDOM]+"," +serverArguments[SERVER_RANDOM]+",true,"+clientMsg;
                    pw.println(msg);
                    pw.flush();
                    break;
                }else {
                    int times = Integer.parseInt(serverArguments[TIMES])+1;
                    int tempClientRandom = Integer.parseInt(serverArguments[CLIENT_RANDOM]);
                    int serverRandom = Integer.parseInt(serverArguments[SERVER_RANDOM]) + 1;
                    if (tempClientRandom != (clientRand+1)){
                        break;
                    }
                    PrintWriter pw = new PrintWriter(client.getOutputStream());
                    String msg = times + "," + serverArguments[IS_SUCCESS] + "," + tempClientRandom+","+serverRandom+","
                            +serverArguments[IS_FINISHED]+",我收到了你的信息，咱两通话吧";
                    pw.println(msg);
                    pw.flush();
                }

            }
        }
        client.close();

//        //-------------------------- 第一次握手 ---------------------------//
//        // 输入要发送的内容
//        Random random = new Random();
//        int clientRand = random.nextInt(1000);
//
//        String msg = "第一次握手："+client.getInetAddress().toString()+","+clientRand;
//
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("请输入内容：");
////        String msg = scanner.nextLine();
////        scanner.close();
//
//        // 利用socket在这个通道里面发送内容
//        PrintWriter pw = new PrintWriter(client.getOutputStream());
//        pw.println(msg);
//        // 必须要flush才会发出去
//        pw.flush();
//        //-------------------------- 第一次握手 ---------------------------//
//
//
//        //-------------------------- 第二次握手 ---------------------------//
//        // 利用socket接收这个通道里面的内容
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String serverMsg = bufferedReader.readLine();
//        System.out.println(serverMsg);
//        String[] server = serverMsg.split(",");
//        int validClientRand = Integer.parseInt(server[server.length-2]); // 约定好倒数第二个是客户端的随机数
//        int serverRand = Integer.parseInt(server[server.length-1]); // 约定好最后一个是服务端的随机数
//        if (validClientRand != clientRand+1){
//            System.out.println("第二次握手失败，client随机数校验失败");
//            client.close();
//        }
//        msg = "第二次握手：" +client.getInetAddress().toString()+"," +(serverRand+1);
//        pw.println(msg);
//        pw.flush();
//        //-------------------------- 第二次握手 ---------------------------//
//
//        System.out.println(bufferedReader.readLine());


        // 关闭连接
//        client.close();
    }
}
