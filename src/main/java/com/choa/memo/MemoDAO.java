package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	//listing, inserting, deleting, view, updating
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="memoMapper.";
	
	public List<MemoDTO> boardList(){
		return sqlSession.selectList(NAMESPACE+"list");
	}
	
	public int boardWrite(MemoDTO memoDTO){
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}
	
	public int boardUpdate(MemoDTO memoDTO){
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	
	public int boardDelete(int num){
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	public MemoDTO boardView(int num){
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}
}
