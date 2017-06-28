package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends Abstract4Test {
	
	@Inject
	private TableService tableService;
	
	@Test
	public void test() throws Exception {
		TableADTO tableADTO=new TableADTO();
		tableADTO.setTitle("t2");
		tableADTO.setWriter("t2");
		tableADTO.setNum(4);
		int result=tableService.insertTable(tableADTO, 4);
		
		Assert.assertNotEquals(0, result);
	}

}
