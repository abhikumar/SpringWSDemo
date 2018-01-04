package com.xav.controller;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(
			ApplicationContext ctx) {
		MessageDispatcherServlet msg = new MessageDispatcherServlet();
		msg.setApplicationContext(ctx);

		return new ServletRegistrationBean(msg, "/codenotfound/ws/*");

	}

	@Bean(name = "helloworld")
	public Wsdl11Definition defaultWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition
				.setWsdl(new ClassPathResource("/wsdl/helloworld.wsdl"));

		return wsdl11Definition;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller=new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.xav.model");
		return jaxb2Marshaller;
	}
	
	@Bean
	public WebServiceTemplate webServiceTemplate()
	{
		   WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		   webServiceTemplate.setMarshaller(jaxb2Marshaller());
		   webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		   webServiceTemplate.setDefaultUri("http://localhost:8080/codenotfound/ws/helloworld");
		return webServiceTemplate;
	}
}
