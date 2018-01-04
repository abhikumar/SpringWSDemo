package com.xav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.xav.model.Greeting;
import com.xav.model.ObjectFactory;
import com.xav.model.Person;

@Component
public class ClientController {

	@Autowired
	WebServiceTemplate webServiceTemplate;

	public String get() {
		ObjectFactory factory = new ObjectFactory();
		Person person = factory.createPerson();

		person.setFirstName("a");
		person.setLastName("k");
		Greeting greeting = (Greeting) webServiceTemplate
				.marshalSendAndReceive(person);
		return greeting.getGreeting();
	}

}
