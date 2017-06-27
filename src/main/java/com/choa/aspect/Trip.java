package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Trip {
	public void go(){
		System.out.println("공항행");
		System.out.println("===================");
	}
}
