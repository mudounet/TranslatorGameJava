/**
 * 
 */
package com.mudounet.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author mudounet
 *
 */
public class QuestionFragmentTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.mudounet.core.QuestionFragment#validate()}.
	 */
	@Test
	public void testValidate() {
		testFragmentValidation("testElement", new String[] {"TESTElennt", "testemnet", "etlmnet"}, new int[] {2, 4, 6});
		testFragmentValidation("testElement", new String[] {"TESTElennt", "testemnet", "etlmnet"}, new int[] {-1, -1, -1});
	}
	
	private void testFragmentValidation(String origString, String[] answers, int[] results) {
		QuestionFragment QFTested = new QuestionFragment(origString);
		assertEquals(origString.length(), QFTested.validate());
		
		for(int idx = 0; idx < answers.length; idx++) {
			QFTested.setAnswer(answers[idx]);
			assertEquals(results[idx], QFTested.validate());
		}
		
		QFTested.setAnswer(origString);
		assertEquals(0, QFTested.validate());
	}

	/**
	 * Test method for {@link com.mudounet.core.QuestionFragment#getFragmentType()}.
	 */
	@Test
	public void testGetFragmentType() {  
		fail("Not yet implemented");
	}
	


	/**
	 * Test method for {@link com.mudounet.core.QuestionFragment#setAnswer(java.lang.String)}.
	 */
	@Test
	public void testSetAnswer() {
		fail("Not yet implemented");
	}

}
