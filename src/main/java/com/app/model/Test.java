package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "K_TEST")
public class Test {

	@Id
	@Column(name = "K_ID")
	private long kid;
	
	@Column(name = "K_NAME")
	private String kname;

	public long getKid() {
		return kid;
	}

	public void setKid(long kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}
	
	
}
