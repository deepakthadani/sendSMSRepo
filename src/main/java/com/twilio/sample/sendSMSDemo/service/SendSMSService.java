package com.twilio.sample.sendSMSDemo.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.sample.sendSMSDemo.model.SMSPojo;
import com.twilio.type.PhoneNumber;

@Service
public class SendSMSService {
	
	@Autowired
	private Environment env;
		
	public void sendSMS(SMSPojo sendSMSPojo) {
		
		String ACCOUNT_SID = env.getProperty("ACCOUNT_SID");
		String AUTH_TOKEN = env.getProperty("AUTH_TOKEN");
				
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		try {
			Message message = Message.creator(
	        		new PhoneNumber(sendSMSPojo.getSendSMSTo()), 
	                new PhoneNumber(sendSMSPojo.getSendSMSFrom()), 
	                sendSMSPojo.getMessage())
				.setStatusCallback(URI.create("https://enbcn01qx69zi.x.pipedream.net"))	
	            .create();
	    
			sendSMSPojo.setSid(message.getSid());
			sendSMSPojo.setResult("Result : Message Sent. Ack no : " + sendSMSPojo.getSid());
		} catch (Exception e) {
	    	sendSMSPojo.setResult("Result : Error in Sending Message. Please enter Phone Number fields in International Number format, along with the message"); 
	    }
		
	    System.out.println(sendSMSPojo.getResult());
	}
	
    public SendSMSService() {
		super();
    }

}
