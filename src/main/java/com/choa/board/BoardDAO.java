package com.choa.board;

	import java.sql.SQLException;

	import java.util.List;

import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

	public interface BoardDAO {
		
		/*public DataSource getDataSource() {
			return dataSource;
		}

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}*/

		public int boardCount(ListInfo listInfo) throws Exception;
		
		public List<BoardDTO> boardList(ListInfo listInfo) throws SQLException;
		
		public int boardWrite(BoardDTO boardDTO) throws SQLException;
		
		public int boardUpdate(BoardDTO boardDTO) throws SQLException;
		
		public int boardDelete(int num) throws SQLException;
		
		public BoardDTO boardView(Integer num) throws SQLException;
		
		public void boardHit(Integer num) throws Exception;
}


