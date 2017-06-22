package com.choa.ex6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){
		System.out.println("test");
	}
}
