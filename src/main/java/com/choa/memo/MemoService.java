package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	
	@Inject
	private MemoDAO memoDAO;
	
	public List<MemoDTO> boardList(){
		return memoDAO.boardList();
	}
	
	public int boardWrite(MemoDTO memoDTO){
		return memoDAO.boardWrite(memoDTO);
	}
	
	public int boardDelete(int num){
		return memoDAO.boardDelete(num);
	}
	
	public int boardUpdate(MemoDTO memoDTO){
		return memoDAO.boardUpdate(memoDTO);
	}
	
	public MemoDTO boardView(int num){
		return memoDAO.boardView(num);
	}
}
