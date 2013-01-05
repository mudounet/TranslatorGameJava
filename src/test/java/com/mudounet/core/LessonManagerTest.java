package com.mudounet.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mudounet.xml.SectionList;

public class LessonManagerTest {
	
	private LessonManager lessonTested;
	

	@Before
	public void setUp() throws Exception {
		lessonTested = new LessonManager();
	}

	@Test
	public void testLoad() throws Exception {
		lessonTested.load(ResourceManager.LoadFile("/lessons.xml"));
		SectionList elts = lessonTested.getList();
		elts.getList();
	}

	@Test
	public void testDisplayGlobalStats() {
		fail("Not yet implemented");
	}

}
