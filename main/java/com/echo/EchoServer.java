package com.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
                // 得到接收过来的数据
                String msg = br.readLine();

                System.out.println("收到" + client.getInetAddress() + "发送的"+ msg);

                // 发送数据
                pw.println(msg);
                pw.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
