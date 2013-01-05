package com.mudounet.xml;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class SectionList {
	@ElementList
	private List<Section> list;

	/**
	 * @return the list
	 */
	public List<Section> getList() {
		return list;
	}
}
