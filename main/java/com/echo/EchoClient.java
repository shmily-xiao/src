package com.echo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by simpletour_Jenkin on 2016/11/3.
 *
 * socket 就是一进一出 client.getInputStream() 和 client.getOutputStream()
 */
public class EchoClient {
    public static void main(String[] args) throws Exception{
        // 建立连接
        Socket client = new Socket("localhost",6789);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        // 输入要发送的内容
        String msg = scanner.nextLine();
        scanner.close();
        // 利用socket在这个通道里面发送内容
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(msg);
        // 必须要flush才会发出去
        pw.flush();
        // 利用socket接收这个通道里面的内容
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(bufferedReader.readLine());

        // 关闭连接
        client.close();
    }
}
