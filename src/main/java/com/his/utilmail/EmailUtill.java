package com.his.utilmail;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.his.dto.User;


@Component
public class EmailUtill {
	
	 @Autowired
     private JavaMailSender javaMailSender;
     
     public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	private String getUnlockAccEmailBody(User user) throws IOException {
    	 
    	 StringBuffer sb=new StringBuffer("");
    	 FileReader fr=new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
    	 BufferedReader br = new BufferedReader(fr);
    	String line= br.readLine(); 
    	while(line!=null) {
    		sb.append(line);
    		line=br.readLine();
    	}
    	br.close();
    	 
    	  String mailBody = sb.toString();
    	  mailBody = mailBody.replace("{FNAME}",user.getUserFristName());
    	  mailBody = mailBody.replace( "{LNAME}",user.getUserLastName());
    	  mailBody = mailBody.replace("{TEMP-PWD}",user.getUserPazzword());
    	  mailBody = mailBody.replace("{EMAIL}",user.getUserEmail());
    	  
    	  return mailBody;
    	  
     }
     
     public boolean sendUserAccUnlockEmail(User user) {
    	 
    	 boolean isSent= false;
    	 
    	 try {
    	 MimeMessage mimeMessage = javaMailSender.createMimeMessage();
 		
 		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
 		helper.setTo(user.getUserEmail());
 		helper.setSubject("Unlock your acc");
 		helper.setText(getUnlockAccEmailBody(user),true);
 		javaMailSender.send(mimeMessage);
 		
 		isSent = true;
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 return isSent;
     }
	
	
}
