package com.zll.qidian.bean;

public class Book {
	private Integer bid;
	private String bname;
	private String author;
	private String short_intro;
	private String intro;
	private String conver_url;
	private Integer tid;
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", short_intro=" + short_intro
				+ ", intro=" + intro + ", conver_url=" + conver_url + ", tid=" + tid + "]";
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getShort_intro() {
		return short_intro;
	}
	public void setShort_intro(String short_intro) {
		this.short_intro = short_intro;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getConver_url() {
		return conver_url;
	}
	public void setConver_url(String conver_url) {
		this.conver_url = conver_url;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
}
