package com.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class NewUserEventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;

	}
	
	public void publish(){
		NewUserEvent ce = new NewUserEvent(this);
		publisher.publishEvent(ce);
	}
}
