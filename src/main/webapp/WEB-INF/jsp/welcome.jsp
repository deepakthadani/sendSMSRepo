<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>
	<h1>Welcome !!! </h1> 
	
	<form:form action="/twilio/submitForm" modelAttribute="SMSPojo">
		
		Send SMS from Phone Number: <form:input path="sendSMSFrom" />  
        <br><br> 
		
		Send SMS to Phone Number: <form:input path="sendSMSTo" />         
        <br><br>  
        
       	Message to be sent: <form:input path="message" />         
        <br><br>  

        ${SMSPojo.result} 
        <br><br>     
        
        <input type="submit" value="Submit" />
        <input type="button" onclick="window.location.href='/twilio';" value="Clear" /> 
		
	</form:form>
	
</div>