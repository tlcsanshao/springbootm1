package com.sanshao.basic.springbootm1.modules.SocketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4567);
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            socket.setKeepAlive(true);
            new Thread(new ClientSocketHandler(socket)).start();
        }
    }

    static class ClientSocketHandler extends Thread {
        Socket socket = null;

        public ClientSocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 根据输入输出流和客户端连接
            try {
                InputStream inputStream = socket.getInputStream();
                // 得到一个输入流，接收客户端传递的信息
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// 提高效率，将自己字节流转为字符流
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 加入缓冲区
                String temp = null;
                String info = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    info += temp;
                    System.out.println("已接收到客户端连接");
                    System.out.println("服务端接收到客户端信息：" + info + ",当前客户端ip为："
                            + socket.getInetAddress().getHostAddress() + ",当前客户端port为：" + socket.getPort());
                }

                OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
                PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
                printWriter.print("你好，服务端已接收到您的信息");
                printWriter.flush();
                socket.shutdownOutput();// 关闭输出流

                // 关闭相对应的资源
                bufferedReader.close();
                inputStream.close();
                printWriter.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
