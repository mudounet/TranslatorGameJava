package com.mudounet.xml.stats;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root
public class Test implements Comparable<Test> {

	@Attribute
	private String key = "";
	
	@Attribute
	private int failed = 0;
	
	@Attribute
	private int total = 0;
	
	@Attribute
	private Date lastUpdate = new Date();
	
	@Attribute
	private Date lastFailed = new Date();
	
	@Attribute
	private MeanList lastResults = new MeanList();

	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		if (this.lastResults.mean() < o.lastResults.mean()) return -1;
		if (this.lastResults.mean() > o.lastResults.mean()) return 1;
		if (this.total < o.total) return -1;
		if (this.total > o.total) return 1;
		return 0;
	}

}
