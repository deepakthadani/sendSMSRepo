package com.twilio.sample.sendSMSDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twilio.sample.sendSMSDemo.model.SMSPojo;
import com.twilio.sample.sendSMSDemo.service.SendSMSService;

@Controller
public class SendSMSController {
	
	@Autowired
	private SendSMSService sendSMSService;
	
    @RequestMapping("/twilio")  
    public String showForm(Model model)  
    {  
      //create a send SMS object   
    	SMSPojo sMSPojo = new SMSPojo();  
      //provide sendSMSPojo object to the model   
    	model.addAttribute("SMSPojo", sMSPojo);  
    	return "welcome";  
    }  
	
	@RequestMapping("/twilio/submitForm")  
	// @ModelAttribute binds form data to the object  
	public String submitForm(@ModelAttribute("SMSPojo") SMSPojo sMSPojo)  
	{   	
		sendSMSService.sendSMS(sMSPojo);
		return "welcome";  
	} 
	
    @RequestMapping("/twilio/response")  
    //read the provided form data  
    public String processResponse(@RequestParam("MessageSid") String messageSid,@RequestParam("MessageStatus") String messageStatus, Model model)  
    {  
    	 System.out.println("SID: " + messageSid + ", Status:" + messageStatus);
         //create a send SMS object   
     	 SMSPojo sMSPojo = new SMSPojo();
     	 sMSPojo.setSid(messageSid);
     	 sMSPojo.setDeliveryStatus(messageStatus);
     	 
     	 //Should ideally save the response from twilio into the database. However in this case just having it displayed on a web page.
     	 
         //provide sendSMSPojo object to the model   
     	 model.addAttribute("SMSPojo", sMSPojo);  
     	 return "listSmsStatus"; 
    }  
	
}
