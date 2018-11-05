package com.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by simpletour_Jenkin on 2016/11/3.
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(ECHO_SERVER_PORT)){

            System.out.println("服务器已经启动...");

            while (true){
                Socket client = serverSocket.accept();
                new Thread(new ClientHandler(client)).start();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static class ClientHandler implements Runnable{
        private Socket client;
        int TIMES = 0;
        int IS_SUCCESS = 1;
        int CLIENT_RANDOM = 2;
        int SERVER_RANDOM = 3;
        int IS_FINISHED = 4;
        int CONTENT = 5;
        int LENGTH = 6;

        public ClientHandler() {
        }

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // br 读取在socket通道里面接收的内容
            try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                // 在通道里面发送想发送的数据
                PrintWriter pw = new PrintWriter(client.getOutputStream())){
                int serverRandom=0;
                while (true){
                    // 得到接收过来的数据
                    String msg = br.readLine();
                    System.out.println(client.getInetAddress() +" 发来信息 ："+ msg);
                    if (msg==null || msg.isEmpty())continue;
                    String[] clientArguments = msg.split(",");
//                    if (clientArguments.length != LENGTH){
//                        System.out.println(client.getInetAddress() +"---参数不合法与其断开连接");
//                        break;
//                    }
                    if ("true".equals(clientArguments[IS_FINISHED])){
                        System.out.println(client.getInetAddress() +"---主动断开连接");
                        break;
                    }
                    int times = Integer.parseInt(clientArguments[TIMES]) +1;
                    int clientRandom = Integer.parseInt(clientArguments[CLIENT_RANDOM])+1;
                    int tempServerRandom = Integer.parseInt(clientArguments[SERVER_RANDOM]);
                    if (times==2 && "false".equals(clientArguments[IS_FINISHED])){
                        serverRandom = new Random().nextInt(1000)+1;
                        String serverMsg = times+",false,"+clientRandom+","+serverRandom+","+clientArguments[IS_FINISHED]+",我收到了你的信息，我需要验证你的信息";
                        System.out.println(serverMsg);
                        pw.println(serverMsg);
                        pw.flush();
                    }else if (times==4&&"false".equals(clientArguments[IS_FINISHED])){

                        if (tempServerRandom != (serverRandom+1)){
                            System.out.println(client.getInetAddress() +"---4参数不合法与其断开连接");
                            break;
                        }
                        String serverMsg = times+",true,"+clientRandom+","+serverRandom+","+clientArguments[IS_FINISHED]+",我通过了你的信息，我们交流吧";
                        System.out.println(serverMsg);
                        pw.println(serverMsg);
                        pw.flush();
                    }
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
