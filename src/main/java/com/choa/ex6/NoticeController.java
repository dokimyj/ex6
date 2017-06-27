package com.choa.ex6;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeServiceImpl;
import com.choa.util.ListInfo;
import com.choa.notice.NoticeDTO;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String list(Model model, ListInfo listInfo) throws Exception{
		System.out.println(noticeService.boardView(1000).getTitle());
		model.addAttribute("list", noticeService.boardList(listInfo));
		model.addAttribute("board", "notice");
		model.addAttribute("listInfo", listInfo);
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public String view(Integer num, Model model) throws Exception{
		if(num==null){ 
			
		}
		NoticeDTO noticeDTO=(NoticeDTO)noticeService.boardView(num);
		model.addAttribute("dto", noticeDTO);
		model.addAttribute("board", "notice");
		return "board/boardView"; 
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String write(Model model){
		model.addAttribute("path", "notice");
		return "board/boardWrite"; 
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String write(NoticeDTO noticeDTO, RedirectAttributes rd, Model model) throws Exception{
		int result=noticeService.boardWrite(noticeDTO);
		String message="Update Failed";
		if(result>0){
			message="Update Succeeded";
		}
		rd.addFlashAttribute("message", message);
		rd.addAttribute("board", "notice");
		return "redirect:noticeList?curPage=1";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(Integer num, Model model) throws Exception{
		this.view(num, model);
		model.addAttribute("path", "notice");
		return "board/boardUpdate"; 
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO, RedirectAttributes rd, Model model) throws Exception{
		int result=noticeService.boardUpdate(noticeDTO);
		String message="Update Failed";
		if(result>0){
			message="Update Succeeded";
		}
		rd.addFlashAttribute("message", message);
		rd.addAttribute("board", "notice");
		return "redirect:noticeList?curPage=1";
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String delete(Integer num, RedirectAttributes rd, Model model) throws Exception{
		int result=noticeService.boardDelete(num);
		String message="Delete Failed";
		if(result>0){
			message="Delete Succeeded";
		}
		rd.addFlashAttribute("message", message);
		rd.addAttribute("board", "notice");
		return "redirect:noticeList?curPage=1";
	}

}
