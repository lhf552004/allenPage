package com.controller;
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.*;  
import javax.mail.internet.*;  
public class SendEmail {
	String host;  
    String username;  
    String password;  
    String fromAddr;  
    String toAddr;  
    String subject;  
    String content;  
  
    public SendEmail()  
    {  
        // �?��?�?始化  
        host = "smtp.qq.com";  
        username = "";  
        password = "";  
        fromAddr = "@";  
    }  
  
    // �?��?邮件  
    public boolean sendMail()  
    {  
        Properties prop;  
        Session session;  
        MimeMessage msg;  
  
        try  
        {  
            prop = new Properties(); // 存储连接�?�数  
            prop.put("mail.smtp.host",host);  
            prop.put("mail.smtp.auth","true");  
  
            session = Session.getDefaultInstance(prop,null); // 获得一个邮件的Session  
            msg = new MimeMessage(session); // 邮件信�?�  
  
            // 检查邮件地�?�是�?��?�法  
            if(fromAddr == null || fromAddr.equals(""))  
            {  
                throw new Exception("�?�件地�?�错误");  
            }  
            if(toAddr == null || toAddr.equals(""))  
            {  
                throw new Exception("目标地�?�错误");  
            }  
  
            //设置�?地�?�  
            msg.setFrom(new InternetAddress(fromAddr));  
            //设置目的地�?�  
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toAddr));  
            //设置主题  
            msg.setSubject(subject);  
  
            Multipart mp = new MimeMultipart(); //邮件内容  
            MimeBodyPart mbpContent = new MimeBodyPart();  
            mbpContent.setContent(content,"text/html"); // 邮件格�?  
  
  
            mp.addBodyPart(mbpContent);  
            msg.setContent(mp);  
            msg.setSentDate(new Date());  
  
            // �?��?邮件  
            Transport transport = session.getTransport("smtp");  
            transport.connect((String)prop.get("mail.smtp.host"),username,password);  
            transport.sendMessage(msg,msg.getRecipients(MimeMessage.RecipientType.TO));  
  
            transport.close();  
            return true;  
        }  
        catch(Exception e)  
        {  
            System.out.println(e);  
            return false;  
        }  
    }  
  
    // getter and setter  
    public String getPassword()  
    {  
        return password;  
    }  
    public void setPassword(String password)  
    {  
        this.password = password;  
    }  
  
    public String getHost()  
    {  
        return host;  
    }  
    public void setHost(String host)  
    {  
        this.host = host;  
    }  
  
    public String getUsername()  
    {  
        return username;  
    }  
    public void setUsername(String username)  
    {  
        this.username = username;  
    }  
  
    public String getFromAddr()  
    {  
        return this.fromAddr;  
    }  
    public void setFromAddr(String addr)  
    {  
        fromAddr = addr;  
    }  
  
    public String getToAddr()  
    {  
        return this.toAddr;  
    }  
    public void setToAddr(String addr)  
    {  
        toAddr = addr;  
    }  
  
    public String getSubject()  
    {  
        return subject;  
    }  
    public void setSubject(String sub)  
    {  
        subject = sub;  
    }  
  
    public String getContent()  
    {  
        return content;  
    }  
    public void setContent(String content)  
    {  
        this.content = content;  
    } 
}
