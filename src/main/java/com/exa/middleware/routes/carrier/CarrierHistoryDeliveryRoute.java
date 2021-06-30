package com.exa.middleware.routes.carrier;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class CarrierHistoryDeliveryRoute extends BaseCarrierRoute{
	
	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		rest("/carriers/history")		
		.produces(MediaType.APPLICATION_JSON_VALUE)
		.consumes(MediaType.APPLICATION_JSON_VALUE)
		.get("{trackingId}")		
		.route()	
		.log(" ${header.trackingId}")
		.to("velocity://./carrier/history/scripted.json")
		.unmarshal().json(JsonLibrary.Jackson);
	}
}
