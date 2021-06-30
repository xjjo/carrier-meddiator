package com.exa.middleware.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RestConfig extends RouteBuilder{

	@Value("${meddiator.api.path}")
	String contextPath;
		
	@Override
	public void configure() throws Exception {		
		restConfiguration()
		 	.component("servlet").contextPath(contextPath)		 			 	
		 	.bindingMode(RestBindingMode.auto)        
		 	.dataFormatProperty("prettyPrint", Boolean.TRUE.toString())    		 	
		 	.port(8080);
	}
	
	@Bean
    ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
        ServletRegistrationBean<CamelHttpTransportServlet> servlet = new ServletRegistrationBean<CamelHttpTransportServlet>(new CamelHttpTransportServlet(), contextPath + "/*");
        servlet.setName("CamelServlet");
        return servlet;
    }

}
