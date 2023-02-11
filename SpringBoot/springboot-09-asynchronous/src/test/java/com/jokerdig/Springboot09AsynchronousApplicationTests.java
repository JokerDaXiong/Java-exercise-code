package com.jokerdig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09AsynchronousApplicationTests {

//    // 注入邮件发送
//    @Autowired
//    JavaMailSenderImpl mailSender;

    // 简单邮件发送
    @Test
    void contextLoads() {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        // 题目
//        mailMessage.setSubject("jokerdig.com");
//        // 正文
//        mailMessage.setText("这是springboot发送的邮件");
//        // 接收人
//        mailMessage.setTo("jokerdaxiong@qq.com");
//        // 发送人
//        mailMessage.setFrom("jokerdaxiong@qq.com");
//        // 发送
//        mailSender.send(mailMessage);

    }

//    // 复杂邮件发送
//    @Test
//    void contextLoads2() throws MessagingException {
//        // 创建一个复杂邮件
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        // 组装复杂邮件
//        MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
//        message.setSubject("jokerdig.com复杂");
//        message.setText("<p style='color:red'>这是springboot发送的带标签复杂邮件</p>",true);
//        // 附件
//        message.addAttachment("1.jpg",new File("1.jpg"));
//        message.setTo("jokerdaxiong@qq.com");
//        message.setFrom("jokerdaxiong@qq.com");
//        // 发送
//        mailSender.send(mimeMessage);
//    }

}
