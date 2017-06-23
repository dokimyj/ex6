package com.choa.util;

public class RowMaker {
	private int firstRow;
	private int lastRow;
	
	public int getFirstRow() {
		return firstRow;
	}	
	public int getLastRow() {
		return lastRow;
	}
	public void setRow(int curPage, int perPage){
		firstRow=(curPage-1)*perPage+1;
		lastRow=curPage*perPage;
	}
}
