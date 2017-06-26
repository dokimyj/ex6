package com.choa.ex6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	
	@Inject
	private MemoService memoService;
	
	@RequestMapping(value="memoList")
	public void memoList(){
	}
	
	@RequestMapping(value="getMemoList", method=RequestMethod.GET)
	@ResponseBody //리턴하는 내용을 view페이지가 아닌 Body안으로 직접 보내버린다는 의미.
	public List<MemoDTO> getMemoList() throws Exception{
		List<MemoDTO> list=memoService.boardList();
		return list;
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	public String memoWrite(String writer, String content, RedirectAttributes ra) throws Exception{
		MemoDTO memoDTO=new MemoDTO();
		memoDTO.setWriter(writer);
		memoDTO.setContent(content);
		memoService.boardWrite(memoDTO);
		return "redirect:getMemoList";
	}
	
	@RequestMapping(value="memoView/{num}") //파라미터 자체를 주소 안에 넣는 방식=RESTful API
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num) throws Exception{
		MemoDTO m=memoService.boardView(num);
		return m;
	}
}
