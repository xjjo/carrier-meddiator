package com.exa.middleware.routes.carrier;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.exa.middleware.services.rest.model.carrier.Delivery;

@Component
public class CarrierRateDeliveryRoute extends BaseCarrierRoute {

	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		rest("/carriers/rate")		
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.consumes(MediaType.APPLICATION_JSON_VALUE)
		.post()
		.type(Delivery.class)
		.route()
		.to("bean-validator://x")
		//.to("log:com.exa.middleware.routes.carrier?level=INFO")
		.to("velocity://carrier/rates/all.json")
		.unmarshal().json(JsonLibrary.Jackson);
		
	}

}
