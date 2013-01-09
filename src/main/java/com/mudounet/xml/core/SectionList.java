package com.mudounet.xml.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class SectionList {
	@ElementList(inline=true)
	private List<Section> list;

	/**
	 * @return the list
	 */
	public List<Section> getList() {
		return list;
	}
	
	/**
	 * @param stream stream to read from
	 * @throws Exception 
	 */
	public static SectionList load(InputStream stream) throws Exception {
		Serializer serializer = new Persister();
		return serializer.read(SectionList.class, stream);
	}
	
	/**
	 * @param stream stream to write to
	 * @throws Exception 
	 */
	public static void save(SectionList list, OutputStream stream) throws Exception {
		Serializer serializer = new Persister();
		serializer.write(list, stream);
	}
}
