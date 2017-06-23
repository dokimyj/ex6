package com.choa.util;

public class PageResult {
	private int perPage;
	private int perBlock;
	private int curPage;
	private PageMaker pm;
	private RowMaker rm;
	
	public PageResult(int curPage){
		this(10, 5, curPage);
	}
	
	public PageResult(int perPage, int curPage){
		this(perPage, 5, curPage);
	}
	
	public PageResult(int perPage, int perBlock, int curPage){
		this.perPage=perPage;
		this.perBlock=perBlock;
		this.curPage=curPage;
	}

	public PageMaker getPm(int totalCount) {
		pm=new PageMaker();
		pm.makePage(totalCount, curPage, perPage, perBlock);
		return pm;
	}

	public RowMaker getRm() {
		rm=new RowMaker();
		rm.setRow(curPage, perPage);
		return rm;
	}
}
