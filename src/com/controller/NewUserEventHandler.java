package com.controller;

import org.springframework.context.ApplicationListener;

public class NewUserEventHandler implements ApplicationListener<NewUserEvent> {

	@Override
	public void onApplicationEvent(NewUserEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.toString());
	}

}
