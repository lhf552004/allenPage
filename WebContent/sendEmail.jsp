<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="java.sql.*,java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%
String pw ="Xingk2525"; 
String tu = "163.com";
String tto="allen.li@muehlbauer.cn";
String ttitle="好空间网络数据库密码修改成功通知信!操作人ip:";
String tcontent="您的会员:zcdnsz 里的 haokongjian 的mysql 数据库,密码已经被修改为:123456 请切记! 操作人ip:127.0.0.1 ,如不是您本人操作说明您的密码已经泄漏,请立即和我们联系! ! ";
Properties props=new Properties();
props.put("mail.transport.protocol", "smtp");  
props.put("mail.smtp.host","smtp.163.com");
props.put("mail.smtp.auth","true");
Session s=Session.getInstance(props);
s.setDebug(true);
MimeMessage message=new MimeMessage(s);

InternetAddress from=new InternetAddress("lhf552016@163.com"); 
message.setFrom(from);
InternetAddress to=new InternetAddress(tto);
message.setRecipient(Message.RecipientType.TO,to);
message.setSubject(ttitle);
message.setSentDate(new Date());

BodyPart mdp=new MimeBodyPart();
mdp.setContent(tcontent,"text/html;charset=gb2312");
Multipart mm=new MimeMultipart();

mm.addBodyPart(mdp);
message.setContent(mm);
message.saveChanges();
Transport transport=s.getTransport("smtp");
transport.connect("smtp.163.com","lhf552016@163.com",pw);
transport.sendMessage(message,message.getAllRecipients());
transport.close();
%>