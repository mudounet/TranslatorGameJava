package com.mudounet.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LessonTest {
	
	private Lesson lessonTested;
	

	@Before
	public void setUp() throws Exception {
		lessonTested = new Lesson();
	}

	@Test
	public void testLoad() throws Exception {
		lessonTested.load(ResourceManager.LoadFile("/lessons.xml"));
		lessonTested.getList();
	}

	@Test
	public void testDisplayGlobalStats() {
		fail("Not yet implemented");
	}

}
