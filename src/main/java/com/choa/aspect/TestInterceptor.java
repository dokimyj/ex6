package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("After Controller");
		
		/*modelAndView.getModelMap(); //모델맵을 가져오면 모델의 key와 value를 가져올 수 있음*/
		Map<String, Object> map=modelAndView.getModel();
		Object list=map.get("list");
		Object listInfo=map.get("listInfo");
		Object board=map.get("board");
		modelAndView.addObject("newval", "new value"); //새로 추가할 수도 있음
		/*modelAndView.setViewName("home");//home.jsp로 이동한다는 뜻 => 뷰페이지 자체를 갈아치울 수 있음
		response.sendRedirect("/");//아예 리다이렉트로 보내버릴 수도 있음.*/		
		
		System.out.println(((List<BoardDTO>)list).get(0).getTitle());
		System.out.println(((ListInfo)listInfo).getCurBlock());
		System.out.println(board);
		super.postHandle(request, response, handler, modelAndView); //무조건 서블릿으로 가기 때문에 리턴 없음
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Before Controller");
		return true; //컨트롤러로 뭔가를 보내고 싶다면 true를, 아니라면 false를.
	}
	
}
