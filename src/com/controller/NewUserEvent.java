package com.controller;

import org.springframework.context.ApplicationEvent;

public class NewUserEvent extends ApplicationEvent {

	public NewUserEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "New user created Event";
	}
	
	

}
