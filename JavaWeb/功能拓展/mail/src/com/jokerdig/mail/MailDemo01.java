package com.jokerdig.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Joker大雄
 * @data 2022/4/22 - 11:35
 **/
public class MailDemo01 {
    // 发送简单邮件
    public static void main(String[] args) throws Exception {
        // 设置服务器 发送协议 用户名密码
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");// 设置qq邮箱服务器
        prop.setProperty("mail.transport.protocol","smtp");// 邮箱发送协议
        prop.setProperty("mail.smtp.auth","true");// 验证用户名密码

        // QQ邮箱 需要设置SSL加密
        MailSSLSocketFactory mssl = new MailSSLSocketFactory();
        mssl.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactory",mssl);

        // 使用 JavaMail 发送邮件5个步骤

        // 1.创建定义整个应用程序所需的环境信息 Session对象 创建监听
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮件用户名 、 授权码
                return new PasswordAuthentication("jokerdaxiong@qq.com","授权码");
            }
        });

        // 开启Session的debug模式 方便查看email运行状态
        session.setDebug(true);

        // 2.通过session得到transport对象
        Transport ts = session.getTransport();

        // 3.使用邮箱用户名和授权码连接邮件服务器
        ts.connect("smtp.qq.com","jokerdaxiong@qq.com","授权码");

        // 4.创建邮件
        // 注意需要传递session
        MimeMessage message = new MimeMessage(session);
        // 指明发件人
        message.setFrom(new InternetAddress("jokerdaxiong@qq.com"));
        // 指明收件人  Message.RecipientType.TO 防止邮件被拦截到垃圾箱
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("jokerdaxiong@163.com"));

        // 邮件的标题
        message.setSubject("Java发送了一封邮件");
        // 邮件的文本内容 和编码
        message.setContent("使用Java实现一封邮件发送 --来自：<a href='https://jokerdig.com'>Hey,Joker</a>","text/html;charset=UTF-8");

        // 5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        System.out.println("发送结束");
        // 6.关闭连接
        ts.close();

    }
}
