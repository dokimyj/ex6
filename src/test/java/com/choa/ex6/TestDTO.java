package com.choa.ex6;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;


import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;


public class TestDTO extends Abstract4Test {

	@Inject
	private MemoService memoService;
	
	@Test
	public void test() throws SQLException {
		MemoDTO memoDTO=new MemoDTO();
		memoDTO.setWriter("test");
		memoDTO.setContent("this");
		int result=memoService.boardWrite(memoDTO);
		Assert.assertEquals(1, result);
	}

}
