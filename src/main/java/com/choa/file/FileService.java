package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.ex6.FileRepo;
import com.choa.util.SeDTO;

@Service
public class FileService {
	
	public Boolean fileDelete(HttpSession session, String filename) throws Exception{
		String realpath=session.getServletContext().getRealPath("resources/upload");
		File f=new File(realpath, filename);
		boolean check=f.delete();
		return check;
	}
	
	public String fileSave(HttpSession session, MultipartFile m) throws Exception{
		FileRepo fr=new FileRepo();
		String fname=fr.filesave(session.getServletContext().getRealPath("resources/upload"), m);
		return fname;
	}
	
	public String seUpload(HttpSession session, SeDTO seDTO) throws Exception{
		//파일 이름 한글로 되어있으면 업로드 하지 말 것.
		String defaultPath="";
		String realName="";
		String oname="";
		String callback="";
		String callback_func="";
		String file_results="";
		if(seDTO.getFiledata()!=null&&seDTO.getFiledata().getOriginalFilename()!=null&&!seDTO.getFiledata().getOriginalFilename().equals("")){
			FileRepo fr=new FileRepo();
			defaultPath=session.getServletContext().getRealPath("resources/upload");
			realName=fr.filesave(defaultPath, seDTO.getFiledata());
			oname=seDTO.getFiledata().getOriginalFilename();
			callback=seDTO.getCallback();
			callback_func=seDTO.getCallback_func();
			file_results="&bNewLine=true&sFileName="+oname+"&sFileURL=/ex6/resources/upload/"+realName; //왜 이걸 쓸까?			
		}else{
			file_results="&errstr=error";	//파일을 넣지 않고 확인을 누른 경우 에러메시지를 띄운다는 뜻	
		}
		return "redirect:"+callback+"?callback_func="+callback_func+file_results;
	}
}
