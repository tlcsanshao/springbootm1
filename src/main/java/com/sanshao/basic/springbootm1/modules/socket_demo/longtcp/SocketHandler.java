package com.sanshao.basic.springbootm1.modules.socket_demo.longtcp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Component
public class SocketHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(SocketHandler.class);

    @Autowired
    MessageHandler messageHandler;


    @Async
    public void handler(Socket socket) {

        LOGGER.info("Handler");
        InputStream in = null;
        OutputStream out = null;

        try {

            in = socket.getInputStream();
            out = socket.getOutputStream();
            messageHandler.heartBeats(socket, in, out);

            byte[] readBuffer = new byte[32];
            while (in.read(readBuffer) > 0) {
                messageHandler.handlerMessage(readBuffer, in, out);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }


    }


}
