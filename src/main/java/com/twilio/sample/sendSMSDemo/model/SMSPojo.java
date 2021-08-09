package com.twilio.sample.sendSMSDemo.model;

public class SMSPojo {
    
    private String sendSMSTo;
    
    private String sendSMSFrom;
    
    private String message;

    private String result;
    
    private String sid;
    
    private String deliveryStatus;

	public String getSendSMSTo() {
		return sendSMSTo;
	}

	public void setSendSMSTo(String sendSMSTo) {
		this.sendSMSTo = sendSMSTo;
	}

	public String getSendSMSFrom() {
		return sendSMSFrom;
	}

	public void setSendSMSFrom(String sendSMSFrom) {
		this.sendSMSFrom = sendSMSFrom;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
    public SMSPojo() {
		super();
    }

    public SMSPojo(String sendSMSTo, String sendSMSFrom, String message, String result) {
    	super();
    	this.sendSMSTo = sendSMSTo;
    	this.sendSMSFrom = sendSMSFrom;
    	this.message = message;
    	this.result = result;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

}
