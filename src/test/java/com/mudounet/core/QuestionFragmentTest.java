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
	
	QuestionFragment QFTested;
	
	@Before
	public void setup() {
		QFTested = new QuestionFragment();   
	}

	/**
	 * Test method for {@link com.mudounet.core.QuestionFragment#validate()}.
	 * @throws Exception 
	 */
	@Test
	public void testValidate() throws Exception {
		testFragmentValidation("testElement", new String[] {"TESTElennt", "testemnet", "etlmnet"}, new int[] {2, 4, 6});
		testFragmentValidation("Познакомьтесь", new String[] {"познrtомьтес", "поerнакьтесь", "поerнакьтеre"}, new int[] {3, 4, 6});
	}
	
	private void testFragmentValidation(String origString, String[] answers, int[] results) throws Exception {
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
	 * @throws Exception 
	 */
	@Test
	public void testGetFragmentType() throws Exception {
		QFTested.setQuestion("Познакомьтесь");
		assertEquals(QuestionFragment.EDITABLE_FRAGMENT, QFTested.getFragmentType());
		assertEquals("Познакомьтесь", QFTested.getQuestion());

		
		QFTested.setQuestion("#Познакомьтесь");
		assertEquals(QuestionFragment.CONSTANT_FRAGMENT, QFTested.getFragmentType());
		assertEquals("Познакомьтесь", QFTested.getQuestion());
		
		QFTested.setQuestion(" : ");
		assertEquals(QuestionFragment.CONSTANT_FRAGMENT, QFTested.getFragmentType());
		assertEquals(" : ", QFTested.getQuestion());
		
		QFTested.setQuestion(", ");
		assertEquals(QuestionFragment.CONSTANT_FRAGMENT, QFTested.getFragmentType());
		assertEquals(", ", QFTested.getQuestion());

		QFTested.setQuestion("! ");
		assertEquals(QuestionFragment.CONSTANT_FRAGMENT, QFTested.getFragmentType());
		assertEquals("! ", QFTested.getQuestion());
		
		QFTested.setQuestion("?");
		assertEquals(QuestionFragment.CONSTANT_FRAGMENT, QFTested.getFragmentType());
		assertEquals("?", QFTested.getQuestion());
	}
	
	@Test(expected=Exception.class)
	public void testGetFragmentType1() throws Exception {
		QFTested.setQuestion("");
	}
	
	@Test(expected=Exception.class)
	public void testGetFragmentType2() throws Exception {
		QFTested.setQuestion(" Познакомьтесь  ");
	}
	
	@Test(expected=Exception.class)
	public void testGetFragmentType3() throws Exception {
		QFTested.setQuestion(" #Познакомьтесь  ");
	}

}
