package com.sanshao.basic.springbootm1.modules.socket_demo.longtcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    public void startAction() {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
            in = socket.getInputStream();
            out = socket.getOutputStream();

            // 客户端发送心跳包
//            new Thread(new StartHeartBeat(in, out, socket)).start();

            byte[] receiveBuffer = new byte[32];
            while (in.read(receiveBuffer) > 0) {
                System.out.println(new String(receiveBuffer));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class StartHeartBeat implements Runnable {

        private InputStream inputStream;
        private OutputStream outputStream;
        private Socket socket;

        public StartHeartBeat(InputStream inputStream, OutputStream outputStream, Socket socket) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
            this.socket = socket;
        }


        @Override
        public void run() {
            String heartbeat = "heart:00001;";
            while (true) {
                try {
                    Thread.sleep(10 * 1000);// 10s发送一次心跳
                    outputStream.write(heartbeat.getBytes());
                    outputStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.startAction();
    }
}
