package com.mudounet.xml.stats;

import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class TestList {
	
	@Attribute
	private String title;

	@ElementList(inline=true)
	private List<Test> list;

	/**
	 * @return the list
	 */
	public List<Test> getList() {
		return list;
	}
	
	public boolean save(OutputStream stream) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Test selectNextTest() {
		Collections.sort(list);
		return null;
	}

	public int displayGlobalStats() {
		// TODO Auto-generated method stub
		return -1;
	}
	
}
