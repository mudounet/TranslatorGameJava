package com.mudounet.xml.core;

import static org.junit.Assert.fail;

import java.io.FileOutputStream;

import org.junit.Before;
import org.junit.Test;

import com.mudounet.core.ResourceManager;

public class SectionListTest {
	
	private SectionList sectionListTested;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLoad() throws Exception {
		SectionList elts = SectionList.load(ResourceManager.LoadFile("/lessons.xml"));
		elts.getList();
	}
	
	@Test
	public void testSave() throws Exception {
		sectionListTested = SectionList.load(ResourceManager.LoadFile("/lessons.xml"));
		FileOutputStream t = new FileOutputStream("savedLesson.xml");
		SectionList.save(sectionListTested, t);
	}

}
