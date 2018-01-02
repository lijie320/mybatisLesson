package cn.et.lesson05.xml;

import java.io.Serializable;

public class Class implements Serializable{
    private int cid;
    private String cname;
    private String caddress;
    private Integer csex;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public Integer getCsex() {
		return csex;
	}
	public void setCsex(Integer csex) {
		this.csex = csex;
	}
}
