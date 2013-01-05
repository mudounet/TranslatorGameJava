package com.mudounet.core;

import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.mudounet.xml.SectionList;

public class LessonManager {
	
	private SectionList list;
	
	/**
	 * @return the list
	 */
	public SectionList getList() {
		return list;
	}

	/**
	 * @param filename the list to set
	 * @throws Exception 
	 */
	public void load(InputStream stream) throws Exception {
		Serializer serializer = new Persister();
//		File source = new File(filename);
//		
//		this.list = serializer.read(SectionList.class, source);
		this.list = serializer.read(SectionList.class, stream);
	}
	public Question selectNextQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
