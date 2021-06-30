package com.exa.middleware.routes.carrier;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.velocity.exception.MethodInvocationException;

import com.exa.middleware.services.rest.error.PrepareErrorResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;


public abstract class BaseCarrierRoute extends RouteBuilder{
	
	@SuppressWarnings("unchecked")
	@Override
	public void configure() throws Exception {
		 			
		onException(InvalidFormatException.class, 
				UnrecognizedPropertyException.class, 
				MismatchedInputException.class, 
				JsonMappingException.class,
				JsonParseException.class,
				BeanValidationException.class)		
		.bean(PrepareErrorResponse.class)
		.handled(true).log("Error processed");										
		
	}
			
}


//https://stackoverflow.com/questions/8592649/apache-camel-is-there-any-way-to-set-a-message-to-fault-without-injecting-the-e