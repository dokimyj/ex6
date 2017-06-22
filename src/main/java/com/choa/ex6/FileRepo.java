package com.choa.ex6;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//파일을 디스크에 저장함
public class FileRepo {
	public String filesave(String realpath, byte[] fileData, String oname) throws IOException{
		File f=new File(realpath);
		if(!f.exists()){
			f.mkdirs();
		}
		String filename=UUID.randomUUID().toString()+oname.substring(oname.indexOf("."));
		File target=new File(f, filename);
		FileCopyUtils.copy(fileData, target);
		return filename;
	}
	
	public String filesave(String realpath, MultipartFile m) throws Exception{
		File f=new File(realpath); //디렉터리가 없는 경우를 대비
		if(!f.exists()){
			f.mkdirs();
		}
		/*String filename=UUID.randomUUID().toString()+m.getOriginalFilename().substring(m.getOriginalFilename().indexOf("."));*/
		Calendar c=Calendar.getInstance();
		String filename=c.getTimeInMillis()+m.getOriginalFilename();
		File target=new File(f, filename);
		m.transferTo(target); //타겟에 데이터를 밀어쳐넣겠다 
		
		return filename; //파일 이름으로 찾아올 수 있게 함
	}
}
