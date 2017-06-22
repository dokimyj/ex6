package com.choa.ex6;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	private String name;
	private MultipartFile f1;
	private MultipartFile f2;
	
	
	public MultipartFile getF2() {
		return f2;
	}
	public void setF2(MultipartFile f2) {
		this.f2 = f2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getF1() {
		return f1;
	}
	public void setF1(MultipartFile f1) {
		this.f1 = f1;
	}
	
}
