package com.choa.ex6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileService;
import com.choa.util.SeDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){
		
	}
	@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception, IOException{
		/*String callback=seDTO.getCallback();
		String callback_func=seDTO.getCallback_func();
		String oname=seDTO.getFiledata().getOriginalFilename();
		String defaultPath=session.getServletContext().getRealPath("resources/upload");
		
		//make directory if not exists
		File f=new File(defaultPath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		//the name that would be saved in the directory
		String realName=UUID.randomUUID().toString()+oname.substring(oname.indexOf("."));
		
		//the file that would be saved in the directory
		
		seDTO.getFiledata().transferTo(new File(f, realName));
		
		String file_results="&bNewLine=true&sFileName="+oname+"&sFileURL=/ex6/resources/upload/"+realName; //왜 이걸 쓸까?
		//아무튼 필요한 부분은 아래와 같다.		*/	
		FileService fileService=new FileService();
		return fileService.seUpload(session, seDTO);		
	}
	
	
	
	//클릭시 파일 다운로드
	@RequestMapping(value="fileDown", method=RequestMethod.GET)
	public ModelAndView fileDown(String fileName, HttpSession session, String oname){
		String realPath=session.getServletContext().getRealPath("resources/upload");
		File f=new File(realPath, fileName);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("download"); //클래스 참조변수와 동일한 view name으로.
		mv.addObject("oname", oname); //원래 파일이름으로 다운받도록 설정하기 위해 받아온 oname을 다시 Download.java로 보내기 위함
		mv.addObject("downloadFile", f); //여기까지만 쓰면 download.jsp가 필요할 것임.
		return mv;
	}
	
	//파일삭제(폴더 내에서도 완전히 삭제하자)
	@RequestMapping(value="fileDelete", method=RequestMethod.GET)
	public void fileDelete(String filename, HttpSession session) throws Exception{
		FileService fileService=new FileService();
		fileService.fileDelete(session, filename);
	}
	//단일파일 업로드
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)*/
	public void fileUpload(MultipartHttpServletRequest request){ 
		
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session) throws Exception{
		FileService fileService=new FileService();
		String fname=fileService.fileSave(session, f1);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("file/fileView");
		mv.addObject("filename", fname);
		mv.addObject("oname", f1.getOriginalFilename());
		return mv;
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
	
	/*@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)*/
	public void sameMultiFileUpload(SameMultiFileDTO sdto){ //아예 DTO에 멀티파트파일 배열을 만들고 배열로 받자!
		for(int i=0;i<sdto.getF1().length;i++){
			System.out.println(sdto.getF1()[i].getOriginalFilename());
		}
	}
	
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(MultipartHttpServletRequest request){ //매개변수 추가시 다중파일 업로드 가능
		List<MultipartFile> al=request.getFiles("f1"); //file's'로 불러와서 파일 배열로 받자!
		for(MultipartFile f:al){
			System.out.println(f.getOriginalFilename());
		}
	}
	/*참고: request로 받는 경우 request.getFileNames()은 파라미터 이름을 모를 때 해당 리퀘스트 내의 파라미터 이름을 Iterator로 뽑아옴.
	 * 	또한, 파라미터 이름이 서로 다른 다중 파일(개수는 정해져 있음)의 경우 request.getFileMap(파라미터이름)으로 받아오면 각 파라미터별로 받아올 수 있음.*/
	
	//다중파일 업로드-파라미터 이름이 고정적이고, 파일 개수는 유동적일 때
	//다중파일 업로드-파라미터 이름이 같고, 파일 개수가 고정되었을 때
		/*@RequestMapping(value="upload", method=RequestMethod.POST)*/
		public void upload(MultipartFile [] f1){ //아예 멀티파트파일 배열 형태로 받자!
			for(int i=0;i<f1.length;i++){
				System.out.println(f1[i].getOriginalFilename());
			}
		}
		
		/*@RequestMapping(value="upload", method=RequestMethod.POST)*/
		public void upload(SameMultiFileDTO sdto){ //아예 DTO에 멀티파트파일 배열을 만들고 배열로 받자!
			for(int i=0;i<sdto.getF1().length;i++){
				System.out.println(sdto.getF1()[i].getOriginalFilename());
			}
		}
		
		@RequestMapping(value="upload", method=RequestMethod.POST)
		public void upload(MultipartHttpServletRequest request){ //매개변수 추가시 다중파일 업로드 가능
			List<MultipartFile> al=request.getFiles("f1"); //file's'로 불러와서 파일 배열로 받자!
			for(MultipartFile f:al){
				System.out.println(f.getOriginalFilename());
			}
		}
	
	//다중파일 업로드-파라미터 이름도 다르고, 파일 개수도 유동적일 때
	//일단 멀티파트파일 객체로는 받을 수 없으며, DTO도 전부 다르므로 사용 불가. => 멀티파트http서블릿리퀘스트로만 가능.
	
	@RequestMapping(value="newUpload", method=RequestMethod.POST)
	public void newUpload(MultipartHttpServletRequest request){ //매개변수 추가시 다중파일 업로드 가능
		Iterator<String> it=request.getFileNames(); 
		//파일이 들어있는 파라미터를 모르므로 getFileNames로 파일객체인 것들의 이름만 불러와서 파라미터 이름을 확인하여 이것들을 받아냅시다.
		ArrayList<MultipartFile> al=new ArrayList();
		while(it.hasNext()){
			MultipartFile m=request.getFile(it.next());
			al.add(m);
		}
		for(MultipartFile multi:al){
			System.out.println(multi.getOriginalFilename());
		}
	}
}
