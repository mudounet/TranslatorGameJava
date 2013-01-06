package com.mudounet.xml;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class TestStat {

	@Attribute
	private int failed = 0;
	
	@Attribute
	private int total = 0;
	
	@Attribute
	private Date lastUpdate = new Date();
	
	@Attribute
	private Date lastFailed = new Date();
	
	@Attribute
	private float meanOfResults = (float) 0.0;
	
	@Attribute
	private StatList lastResults = new StatList();

}
