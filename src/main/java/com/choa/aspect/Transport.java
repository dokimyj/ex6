package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	
	public void bus(){//핵심로직1
		System.out.println("Search for Sitting...");
		System.out.println("Sneaking into others' Cell");
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}
	public void subway(){//핵심로직2
		System.out.println("Search for Sitting...");
		System.out.println("Deresute");
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
	}
}
