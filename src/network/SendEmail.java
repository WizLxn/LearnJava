package network;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by lixiaoning on 16/4/7.
 */
public class SendEmail {

    public static void main(String[] args) {
        String to = "abcd@gmail.com";
        String from = "web@gmail.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        //设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        //获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //头部字段 to
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            //头部字段  subject
            message.setSubject("This is the Subject Line!");

            message.setText("This is the actual message");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
