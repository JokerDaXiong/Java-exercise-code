package com.jokerdig.util;

import com.jokerdig.pojo.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author Joker大雄
 * @data 2022/4/22 - 14:09
 **/
public class SendMail extends Thread{
    // 发送的邮箱
    private String from = "jokerdaxiong@qq.com";
    // 接收者邮箱
    private String username = "jokerdaxiong@qq.com";
    // 授权码
    private String password = "授权码";
    // 发送邮件服务器
    private String host = "smtp.qq.com";

    private User user;

    public SendMail(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            // 设置服务器 发送协议 用户名密码
            Properties prop = new Properties();
            prop.setProperty("mail.host",host);// 设置qq邮箱服务器
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
                    return new PasswordAuthentication(from,password);
                }
            });

            // 开启Session的debug模式 方便查看email运行状态
            session.setDebug(true);

            // 2.通过session得到transport对象
            Transport ts = session.getTransport();

            // 3.使用邮箱用户名和授权码连接邮件服务器
            ts.connect(host,username,password);

            // 4.创建邮件
            // 注意需要传递session
            MimeMessage message = new MimeMessage(session);
            // 指明发件人
            message.setFrom(new InternetAddress(from));
            // 指明收件人  Message.RecipientType.TO 防止邮件被拦截到垃圾箱
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));

            // 邮件的标题
            message.setSubject("Hey,Joker用户注册");
            // 邮件的文本内容 和编码
            String info = "恭喜注册成功，您的账号：<b>"+user.getUsername()+"</b> 密码：<b>"+user.getPassword()+"</b>，请妥善保管。 --来自：<a href='https://jokerdig.com'>Hey,Joker</a>";
            message.setContent(info,"text/html;charset=UTF-8");

            // 5.发送邮件
            ts.sendMessage(message,message.getAllRecipients());

            System.out.println("发送结束");
            // 6.关闭连接
            ts.close();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
