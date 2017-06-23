package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView{ //Download클래스가 단순히 자바클래스가 아닌, view 그 자체가 되기 위해 상속

	public Download(){
		setContentType("application/download;charset=UTF-8"); 
		//json 보낼 때 header파일에 application:json을 보냈듯이 header에 어떤 연결프로그램을  연결할 것인가에 설명
		
		
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ModelAndView에서 mv.addObject는 사실 Map<mv.addObject의 이름, mv.addObject에서 담은 파일객체>객체였습니다!
		File f=(File)model.get("downloadFile");
		String oname=(String)model.get("oname");
		response.setCharacterEncoding(getContentType()); //생성자에서 set한 것을 get하여 세팅
		response.setContentLength((int)f.length());//보내져 온 파일의 길이를 세팅
		/*String fileName=URLEncoder.encode(f.getName(), "UTF-8"); //받아온 파일 이름을 UTF-8로 세팅하기 위해 URLEncoder라는 스태틱 클래스를 호출*/
		response.setHeader("content-Disposition", "attachment;filename=\""+oname+"\""); //헤더를 세팅할 때, filename으로 \파일이름\을 세팅함
		response.setHeader("content-Transfer-Encoding", "binary"); //파일이 이진코드로 전송될 것임을 암시
		OutputStream out=response.getOutputStream(); //아웃풋스트림과 서버가 연결되어있음을 의미
		FileInputStream fis=null;
		fis=new FileInputStream(f);//파일인풋스트림으로 이진데이터를 꺼내옴
		
		FileCopyUtils.copy(fis, out); //파일 저장할때 썼던 그 클래스를 가져옴
		fis.close();//다 보냈으니 인풋스트림 끄기
		out.close();//다 보냈으니 아웃풋스트림 끄기
	}
}
