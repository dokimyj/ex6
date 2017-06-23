package com.choa.notice;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.PageResult;
import com.choa.util.RowMaker;

@Service
public class NoticeServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("notice")
	private NoticeDAOImpl noticeDAO;
	
	@RequestMapping(value="/test")
	public void test(){
		System.out.println(noticeDAO);
	}
	/*public NoticeService(NoticeDAO noticeDAO){
		this.noticeDAO=noticeDAO;
	}
	 */
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int result=noticeDAO.boardCount(listInfo);
		listInfo.makePage(result, 5);
		listInfo.setRow(listInfo.getCurPage(), listInfo.getPerPage());
		return noticeDAO.boardList(listInfo);
	}

	@Override
	public BoardDTO boardView(Integer num) throws Exception {
		return noticeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(Integer num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
}
