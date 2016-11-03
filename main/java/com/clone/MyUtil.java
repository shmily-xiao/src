package com.clone;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by simpletour_Jenkin on 2016/10/28.
 */
public class MyUtil {

    private MyUtil(){
        throw new AssertionError();
    }

    public static <T> T clone(T obj) throws Exception{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    // 流字符流和字节流
    public static void fileCopy(String source, String target) throws IOException{
        try(InputStream in = new FileInputStream(source)){
            try(OutputStream out = new FileOutputStream(target)){

                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1){
                    out.write(buffer, 0, bytesToRead); // 感觉有问题
                }

            }
        }
    }


    public static void fileCopyNIO(String source, String target) throws IOException{
        try (FileInputStream in = new FileInputStream(source)){
            try (FileInputStream out = new FileInputStream(target)){
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1){
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }

        }
    }





}
