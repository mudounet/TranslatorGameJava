package com.mudounet.xml;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Section {

	@ElementList
	private List<Test> list;

	/**
	 * @return the list
	 */
	public List<Test> getList() {
		return list;
	}
	
}
