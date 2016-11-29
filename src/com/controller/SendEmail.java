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
        // å?˜é‡?åˆ?å§‹åŒ–  
        host = "smtp.qq.com";  
        username = "";  
        password = "";  
        fromAddr = "@";  
    }  
  
    // å?‘é€?é‚®ä»¶  
    public boolean sendMail()  
    {  
        Properties prop;  
        Session session;  
        MimeMessage msg;  
  
        try  
        {  
            prop = new Properties(); // å­˜å‚¨è¿žæŽ¥å?‚æ•°  
            prop.put("mail.smtp.host",host);  
            prop.put("mail.smtp.auth","true");  
  
            session = Session.getDefaultInstance(prop,null); // èŽ·å¾—ä¸€ä¸ªé‚®ä»¶çš„Session  
            msg = new MimeMessage(session); // é‚®ä»¶ä¿¡æ?¯  
  
            // æ£€æŸ¥é‚®ä»¶åœ°å?€æ˜¯å?¦å?ˆæ³•  
            if(fromAddr == null || fromAddr.equals(""))  
            {  
                throw new Exception("å?‘ä»¶åœ°å?€é”™è¯¯");  
            }  
            if(toAddr == null || toAddr.equals(""))  
            {  
                throw new Exception("ç›®æ ‡åœ°å?€é”™è¯¯");  
            }  
  
            //è®¾ç½®æº?åœ°å?€  
            msg.setFrom(new InternetAddress(fromAddr));  
            //è®¾ç½®ç›®çš„åœ°å?€  
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toAddr));  
            //è®¾ç½®ä¸»é¢˜  
            msg.setSubject(subject);  
  
            Multipart mp = new MimeMultipart(); //é‚®ä»¶å†…å®¹  
            MimeBodyPart mbpContent = new MimeBodyPart();  
            mbpContent.setContent(content,"text/html"); // é‚®ä»¶æ ¼å¼?  
  
  
            mp.addBodyPart(mbpContent);  
            msg.setContent(mp);  
            msg.setSentDate(new Date());  
  
            // å?‘é€?é‚®ä»¶  
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
