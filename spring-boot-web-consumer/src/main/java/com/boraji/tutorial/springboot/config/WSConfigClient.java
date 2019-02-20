package com.boraji.tutorial.springboot.config;

import com.boraji.tutorial.springboot.clients.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfigClient {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.concretepage.wsdl");
		return marshaller;
	}
	@Bean
	public UserClient userClient (Jaxb2Marshaller marshaller) {
		UserClient client = new UserClient();
		client.setDefaultUri("http://localhost:8080/soapws/articles.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
