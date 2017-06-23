package com.choa.notice;

import java.sql.Date;

import com.choa.board.BoardDTO;

public class NoticeDTO extends BoardDTO {

	public String getAddfile() {
		return addfile;
	}
	public void setAddfile(String addfile) {
		this.addfile = addfile;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	private String addfile;
	private String originalfile;

}
