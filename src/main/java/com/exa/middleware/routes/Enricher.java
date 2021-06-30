package com.exa.middleware.routes;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// 
// https://stackoverflow.com/questions/10610820/apache-camel-to-aggregate-multiple-rest-service-responses

//@Component this is to avoid loading it
public class Enricher extends RouteBuilder{

	@Override
	public void configure() throws Exception {
						

		 restConfiguration()
		 	.component("servlet")		 			 	
		 	.bindingMode(RestBindingMode.auto)        
		 	.dataFormatProperty("prettyPrint", "true")         
		 	.port(8080);				
		
		rest("/temp").produces("text/plain").get()
		.route()
		.multicast(new AggregationStrategy() {			
			@Override
			public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
				if(oldExchange == null){
					return newExchange;
				}else {					
					newExchange.getIn().setBody("{ \"result\": \""+ (String) newExchange.getIn().getBody() +" " +(String) oldExchange.getIn().getBody() + "\" }");
					return newExchange;
				}
			}
		}).parallelProcessing()
	    .enrich("direct:one")
	    .enrich("direct:two")
	    .end()	   
	    .to("mock:result");
		
		from("direct:one").id("from one")
		.bean("beanOne")
		//.log("${body}")
		;
		
		from("direct:two").id("from two")
		.bean("beanTwo")
		//.log("${body}")
		;
				
		
	}
	@Bean
	public BeanOne beanOne(){
		return new BeanOne();
	}
	@Bean
	public BeanTwo beanTwo() {
		return new BeanTwo();
	}
}
	