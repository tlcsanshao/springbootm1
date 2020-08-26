package com.sanshao.basic.springbootm1;

import com.sanshao.basic.springbootm1.mail.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootm1ApplicationTests {

    @Autowired
    MailServiceImpl mailService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("qianyinqy@163.com", "test simple mail", " hello this is simple mail");
    }

}
