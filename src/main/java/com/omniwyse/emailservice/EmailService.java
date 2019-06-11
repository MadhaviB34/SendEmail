package com.omniwyse.emailservice;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailService {
	String html ="<html>\n" + 
			"<head>\n" + 
			"<script type=\"application/ld+json\">\n" + 
			"{\n" + 
			"  \"@context\": \"http://schema.org\",\n" + 
			"  \"@type\": \"EventReservation\",\n" + 
			"  \"reservationNumber\": \"E123456789\",\n" + 
			"  \"reservationStatus\": \"http://schema.org/Confirmed\",\n" + 
			"  \"underName\": {\n" + 
			"    \"@type\": \"Person\",\n" + 
			"    \"name\": \"John Smith\"\n" + 
			"  },\n" + 
			"  \"reservationFor\": {\n" + 
			"    \"@type\": \"Event\",\n" + 
			"    \"name\": \"Foo Fighters Concert\",\n" + 
			"    \"performer\": {\n" + 
			"      \"@type\": \"Organization\",\n" + 
			"      \"name\": \"The Foo Fighters\",\n" + 
			"      \"image\": \"http://www.amprocktv.com/wp-content/uploads/2027/01/foo-fighters-1-680x383.jpg\"\n" + 
			"    },\n" + 
			"    \"startDate\": \"2019-07-09T19:30:00-08:00\",\n" + 
			"    \"location\": {\n" + 
			"      \"@type\": \"Place\",\n" + 
			"      \"name\": \"AT&T Park\",\n" + 
			"      \"address\": {\n" + 
			"        \"@type\": \"PostalAddress\",\n" + 
			"        \"streetAddress\": \"24 Willie Mays Plaza\",\n" + 
			"        \"addressLocality\": \"San Francisco\",\n" + 
			"        \"addressRegion\": \"CA\",\n" + 
			"        \"postalCode\": \"94107\",\n" + 
			"        \"addressCountry\": \"US\"\n" + 
			"      }\n" + 
			"    }\n" + 
			"  },\n" + 
			"  \"ticketToken\": \"qrCode:AB34\",\n" + 
			"  \"ticketNumber\": \"abc123\",\n" + 
			"  \"numSeats\": \"1\"\n" + 
			"}\n" + 
			"</script>\n" + 
			"  </head>\n" + 
			"  <body>\n" + 
			"    <p>\n" + 
			"     Event is reseved and saved into calender.\n" + 
			"     \n" + 
			"    </p>\n" + 
			"  </body>\n" + 
			"</html>\n" + 
			"\n" + 
			"\n" + 
			"\n" + 
			"\n" + 
			"\n" + 
			"\n" + 
			"";
	public static void main(String[] args) throws AddressException, MessagingException, IOException, EmailException {
		new EmailService().sendEmail();
	}

	public String sendEmail() throws AddressException, MessagingException, IOException, EmailException {
		sendmail();
		return "Email sent successfully";
	}

	private void sendmail() throws AddressException, MessagingException, IOException, EmailException {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("madhavi.cse34@gmail.com", "madhucse34");
			}
		});

		MimeMessage message = new MimeMessage(session); 
		   
        message.setFrom(new InternetAddress("madhavi.cse34@gmail.com")); 
 
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("madhavi.cse34@gmail.com")); 
 
        message.setSubject("This is Suject"); 
        message.setHeader("Content-Type", "text/html");
        message.setSentDate(new Date());
        String str = "<html>\n" + 
        		"<head>\n" + 
        		"<script type=\"application/ld+json\">\n" + 
        		"{\n" + 
        		"  \"@context\": \"http://schema.org\",\n" + 
        		"  \"@type\": \"EventReservation\",\n" + 
        		"  \"reservationNumber\": \"E123456789\",\n" + 
        		"  \"reservationStatus\": \"http://schema.org/Confirmed\",\n" + 
        		"  \"underName\": {\n" + 
        		"    \"@type\": \"Person\",\n" + 
        		"    \"name\": \"John Smith\"\n" + 
        		"  },\n" + 
        		"  \"reservationFor\": {\n" + 
        		"    \"@type\": \"Event\",\n" + 
        		"    \"name\": \"Foo Fighters Concert\",\n" + 
        		"    \"performer\": {\n" + 
        		"      \"@type\": \"Organization\",\n" + 
        		"      \"name\": \"The Foo Fighters\",\n" + 
        		"      \"image\": \"http://www.amprocktv.com/wp-content/uploads/2027/01/foo-fighters-1-680x383.jpg\"\n" + 
        		"    },\n" + 
        		"    \"startDate\": \"2019-07-08T19:30:00-08:00\",\n" + 
        		"    \"location\": {\n" + 
        		"      \"@type\": \"Place\",\n" + 
        		"      \"name\": \"AT&T Park\",\n" + 
        		"      \"address\": {\n" + 
        		"        \"@type\": \"PostalAddress\",\n" + 
        		"        \"streetAddress\": \"24 Willie Mays Plaza\",\n" + 
        		"        \"addressLocality\": \"San Francisco\",\n" + 
        		"        \"addressRegion\": \"CA\",\n" + 
        		"        \"postalCode\": \"94107\",\n" + 
        		"        \"addressCountry\": \"US\"\n" + 
        		"      }\n" + 
        		"    }\n" + 
        		"  },\n" + 
        		"  \"ticketToken\": \"qrCode:AB34\",\n" + 
        		"  \"ticketNumber\": \"abc123\",\n" + 
        		"  \"numSeats\": \"1\"\n" + 
        		"}\n" + 
        		"</script>\n" + 
        		"  </head>\n" + 
        		"  <body>\n" + 
        		"    <p>\n" + 
        		"     Event is reseved and saved into calender.\n" + 
        		"     \n" + 
        		"    </p>\n" + 
        		"  </body>\n" + 
        		"</html>\n" + 
        		"\n" + 
        		"\n" + 
        		"\n" + 
        		"\n" + 
        		"\n" + 
        		"\n" + 
        		"";
        String regex = "<script type=\"application\\/ld\\+json\">(.*)<\\/script>";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
          System.out.println(matcher.group(1));
        }
 
        Multipart mp = new MimeMultipart();
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(str,"text/html; charset=utf-8");
        htmlPart.setHeader("MIME_VERSION", "1.0" );
        
        mp.addBodyPart(htmlPart);
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);
        System.out.println("Mail successfully sent");
		
		
	}
}