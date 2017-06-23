package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.ex6.FileRepo;

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
}
