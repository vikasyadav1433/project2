package com.mygroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test1 {

	@Id
	private String col1;
	private String col2;
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	
	
}
