package com.sanshao.basic.springbootm1.modules.socket_demo.longtcp;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Component
@Slf4j
public class MessageHandler {

    @Async
    public void handlerMessage(byte[] readBuffer, InputStream in, OutputStream out) {
        log.info(new String(readBuffer));
        String returnMessage = "heart:00088;";
        sendMessageToClient(returnMessage.getBytes(), out);

    }

    @Async
    public void heartBeats(Socket socket, InputStream inputStream, OutputStream outputStream) {
        log.info("HeartBeats");
        String heartbeat = "heart:00009;";
        while (true) {
            if (socket.isClosed()) {
                return;
            }
            try {
                Thread.sleep(1 * 1000);// 10s发送一次心跳
                outputStream.write(heartbeat.getBytes());
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    public void sendMessageToClient(byte[] messageBuffer, OutputStream out) {

        try {
            out.write(messageBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
