package com.sanshao.basic.springbootm1.modules.socket_demo.longtcp;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;

@Component
@Slf4j
public class SocketServer implements CommandLineRunner {


    @Autowired
    SocketHandler socketHandler;


    @Override
    public void run(String... args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);  //端口号
            log.info("服务端服务启动监听：");
            //通过死循环开启长连接，开启线程去处理消息
            while (true) {
                Socket socket = serverSocket.accept();
                socketHandler.handler(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
