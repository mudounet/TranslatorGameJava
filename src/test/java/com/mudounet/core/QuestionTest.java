package com.mudounet.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class QuestionTest {
	
	Question questionTested;

	@Before
	public void setup() {
		questionTested = new Question();   
	}
	
	/**
	 * Test method for {@link com.mudounet.core.Question#getAnswerList()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetAnswerList() throws Exception {
			testGetAnswerListValidation("Как по-французски \"конечно\"?", new String[] {"Как", " ", "по", "-", "французски", " \"", "конечно", "\"?"});
			testGetAnswerListValidation("#Вы замужем? - #Да, замужем.", new String[] {"Вы", " ", "замужем", "? - ", "Да", ", ", "замужем", "."});		
	}

	@Test
	public void testSetAnswer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResults() {
		fail("Not yet implemented");
	}
	
	private void testGetAnswerListValidation(String expectedAnswer, String[] answers) throws Exception {
		questionTested.setAnswer(expectedAnswer);
		ArrayList<AnswerFragment> elements = questionTested.getAnswerList();
		
		for(int idx = 0; idx < answers.length; idx++) {
			assertEquals(answers[idx], elements.get(idx).getQuestion());
		}
	}

}
