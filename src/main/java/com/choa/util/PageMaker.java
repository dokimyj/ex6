package com.choa.util;

public class PageMaker {
	private int curBlock;
	private int totalBlock;
	private int firstNum;
	private int lastNum;
	public int getCurBlock() {
		return curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	
	public void makePage(int totalCount, int curPage, int perPage, int perBlock){
		int totalPage=(totalCount-1)/perPage+1;
		totalBlock=(totalPage-1)/perBlock+1;
		curBlock=(curPage-1)/perBlock+1;
		firstNum=(curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;
		if(curBlock==totalBlock){
			lastNum=totalPage;
		}
	}
}
