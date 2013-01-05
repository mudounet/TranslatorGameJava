package com.mudounet.core;

import java.io.File;
import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.mudounet.xml.SectionList;

public class Lesson {

	private LessonManager lessonManager;
	private StatManager statManager;
	
	public int displayGlobalStats() {
		return statManager.displayGlobalStats() ;
	}
	
}
