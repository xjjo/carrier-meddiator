package com.exa.middleware.routes.carrier;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.exa.middleware.services.rest.carrier.delivery.NewDeliveryRequestValidator;
import com.exa.middleware.services.rest.error.PrepareErrorResponse;
import com.exa.middleware.services.rest.exceptions.ValidationException;
import com.exa.middleware.services.rest.model.carrier.NewDelivery;

@Component
public class CarrierNewDeliveryRoute extends BaseCarrierRoute{

	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		onException(ValidationException.class)		
		.bean(PrepareErrorResponse.class)
		.handled(true).log("Error processed");	
		
		rest("/carriers/delivery")		
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.consumes(MediaType.APPLICATION_JSON_VALUE)
		.post()
		.type(NewDelivery.class)
		.route()
		.to("bean-validator://x")
		.bean(NewDeliveryRequestValidator.class)
		//.to("log:com.exa.middleware.routes.carrier?level=INFO")
		.to("velocity://carrier/new-delivery/scripted.json")
		.unmarshal().json(JsonLibrary.Jackson);
		
	}

}
