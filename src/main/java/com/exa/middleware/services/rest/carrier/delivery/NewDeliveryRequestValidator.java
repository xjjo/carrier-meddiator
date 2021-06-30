package com.exa.middleware.services.rest.carrier.delivery;

import java.util.Arrays;

import org.apache.camel.Handler;

import com.exa.middleware.services.rest.exceptions.ValidationException;
import com.exa.middleware.services.rest.model.carrier.NewDelivery;

public class NewDeliveryRequestValidator {

	@Handler
	public void validate(NewDelivery delivery) {
		String[] sucDeliveryIds = new String[] {"1000","2000","3000"};
		boolean envSuc = Arrays.stream(sucDeliveryIds).anyMatch(delivery.getId()::equals);
		
		if( envSuc && delivery.getCpDestino() == null) {
			throw new ValidationException("Bad Request", "field cp_destino: can not be null.");
		}	
		
		String[] domDeliveryIds = new String[] {"1101","2101","3101"};
		boolean envDom = Arrays.stream(domDeliveryIds).anyMatch(delivery.getId()::equals);
		
		if( envDom && delivery.getDestino() == null) {
			throw new ValidationException("Bad Request", "field destino: can not be null.");
		}	
	}
}
