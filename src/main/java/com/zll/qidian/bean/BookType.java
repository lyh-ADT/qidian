package com.zll.qidian.bean;

public class BookType {
	private int tid;
	private String tname;
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "BookType [tid=" + tid + ", tname=" + tname + "]";
	}
	
}
