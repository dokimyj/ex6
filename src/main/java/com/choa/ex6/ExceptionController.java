package com.choa.ex6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //그냥 컨트롤러가 아니라 advice컨트롤러라는 뜻의 annotation
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model model){
		model.addAttribute("exceptions", e);
		return "error/notfound";
	} 
	
}
