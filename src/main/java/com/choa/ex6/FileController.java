package com.choa.ex6;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){
		System.out.println("test");
	}
	
	//단일파일 업로드
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)*/
	public void fileUpload(MultipartHttpServletRequest request){ 
		
	}
	
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)*/
	public void fileUpload(MultipartFile f1){
		
	}
	
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)*/
	public void fileUpload(FileDTO fileDTO){ 
		
	}
	
	//다중파일 업로드-파라미터 이름이 다르고, 파일 개수가 고정되었을 때
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultiFileDTO multiFileDTO){
		System.out.println(multiFileDTO.getF1().getOriginalFilename());
		System.out.println(multiFileDTO.getF2().getOriginalFilename());
	}
	/*@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)*/
	public void multiFileUpload(MultipartFile f1, MultipartFile f2){ //매개변수를 추가하면 다중파일 업로드 가능
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}
	/*@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)*/
	public void multiFileUpload(MultipartHttpServletRequest request){ //매개변수 추가시 다중파일 업로드 가능
		MultipartFile file=request.getFile("f1");
		MultipartFile file2=request.getFile("f2");
		System.out.println(file.getOriginalFilename());
		System.out.println(file2.getOriginalFilename());
	}
	
	//다중파일 업로드-파라미터 이름이 같고, 파일 개수가 고정되었을 때
	/*@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)*/
	public void sameMultiFileUpload(MultipartFile [] f1){ //아예 멀티파트파일 배열 형태로 받자!
		for(int i=0;i<f1.length;i++){
			System.out.println(f1[i].getOriginalFilename());
		}
	}
	
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(SameMultiFileDTO sdto){ //아예 DTO에 멀티파트파일 배열을 만들고 배열로 받자!
		for(int i=0;i<sdto.getF1().length;i++){
			System.out.println(sdto.getF1()[i].getOriginalFilename());
		}
	}
	
	public void sameMultiFileUpload(MultipartHttpServletRequest request){ //매개변수 추가시 다중파일 업로드 가능
		List<MultipartFile> al=request.getFiles("f1"); //file's'로 불러와서 파일 배열로 받자!
		for(MultipartFile f:al){
			System.out.println(f.getOriginalFilename());
		}
	}
	/*참고: request로 받는 경우 request.getFileNames()은 파라미터 이름을 모를 때 해당 리퀘스트 내의 파라미터 이름을 Iterator로 뽑아옴.
	 * 	또한, 파라미터 이름이 서로 다른 다중 파일(개수는 정해져 있음)의 경우 request.getFileMap(파라미터이름)으로 받아오면 각 파라미터별로 받아올 수 있음.*/
	
	//다중파일 업로드-파라미터 이름이 같고, 파일 개수도 유동적일 때
	
	//다중파일 업로드-파라미터 이름도 다르고, 파일 개수도 유동적일 때
}
