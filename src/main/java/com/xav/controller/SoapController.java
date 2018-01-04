package com.xav.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xav.model.Greeting;
import com.xav.model.ObjectFactory;
import com.xav.model.Person;

@Endpoint
public class SoapController {

	@PayloadRoot(namespace = "http://codenotfound.com/types/helloworld", localPart = "person")
	@ResponsePayload
	public Greeting sayHello(@RequestPayload Person request) {

		String greeting = "Hello " + request.getFirstName() + " "
				+ request.getLastName() + "!";

		ObjectFactory factory = new ObjectFactory();
		Greeting response = factory.createGreeting();
		response.setGreeting(greeting);

		return response;
	}
}
