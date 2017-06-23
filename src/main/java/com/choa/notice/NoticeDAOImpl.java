package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

@Repository("notice")
public class NoticeDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="noticeMapper.";
	/*@RequestMapping(value="test")
	public void test(){
		System.out.println(dataSource);
	}*/
	/*public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	@Override
	public int boardCount(ListInfo listInfo) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}

	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws SQLException{
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}

	@Override
	public int boardWrite(BoardDTO noticeDTO) throws SQLException{
		return sqlSession.insert(NAMESPACE+"write", noticeDTO);
	}

	@Override
	public int boardUpdate(BoardDTO noticeDTO) throws SQLException{
		return sqlSession.update(NAMESPACE+"update", noticeDTO);
	}

	@Override
	public int boardDelete(int num) throws SQLException{
		return sqlSession.delete(NAMESPACE+"delete", num);
	}

	@Override
	public BoardDTO boardView(Integer num) throws SQLException{
		return sqlSession.selectOne(NAMESPACE+"view", num); //리턴타입 T=xml파일의 view에서 설정한 리턴타입을 의미.
	}

	@Override
	public void boardHit(Integer num) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
