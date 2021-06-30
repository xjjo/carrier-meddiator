package com.exa.middleware.services.rest.error;

import javax.validation.ConstraintViolation;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Message;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.velocity.exception.MethodInvocationException;
import org.springframework.http.MediaType;

import com.exa.middleware.services.rest.exceptions.ValidationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;


public class PrepareErrorResponse {
	 @SuppressWarnings("deprecation")
	@Handler
	    public void prepareErrorResponse(Exchange exchange) {
	        Throwable cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
	        
	        String humanErrMess = null;
	        
	        if (cause instanceof InvalidFormatException) {
	        	InvalidFormatException validationEx = (InvalidFormatException) cause;
	        	humanErrMess = "Invalid format value: " + validationEx.getValue();	            
	        }else if (cause instanceof UnrecognizedPropertyException) {
	        	UnrecognizedPropertyException validationEx = (UnrecognizedPropertyException) cause;	        	
	        	humanErrMess = "Invalid property name: " + validationEx.getPropertyName();
	        }else if(cause instanceof MismatchedInputException) {
	        	MismatchedInputException validationEx = (MismatchedInputException) cause;	
	        	humanErrMess = "Mismached imput in line: " + validationEx.getLocation().getLineNr() + ", column: " + validationEx.getLocation().getColumnNr();	        	
	        }else if(cause instanceof JsonMappingException) {
	        	JsonMappingException validationEx = (JsonMappingException) cause;	
	        	humanErrMess = validationEx.getOriginalMessage();
	        }else if(cause instanceof JsonParseException) {
	        	JsonParseException validationEx = (JsonParseException) cause;
	        	humanErrMess = validationEx.getOriginalMessage();
	        }else if(cause instanceof BeanValidationException) {
	        	BeanValidationException validationEx = (BeanValidationException) cause;
	        	ConstraintViolation<Object> constraintViolation = validationEx.getConstraintViolations().iterator().next();
	        	humanErrMess = constraintViolation.getPropertyPath().toString() +": " + constraintViolation.getMessage();
	        }else if(cause instanceof ValidationException) {
	        	ValidationException validationEx = (ValidationException) cause;	
	        	humanErrMess = validationEx.getMessage();
	        }
	        
	        Message msg = exchange.getIn();
	        msg.setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON);
	        msg.setHeader(Exchange.HTTP_RESPONSE_CODE, 400);

	        
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setError("Bad Request");
	        errorResponse.setReason(humanErrMess!= null?humanErrMess:cause.getMessage());
	        	       
	        msg.setBody(errorResponse);
	       
	    }
}
