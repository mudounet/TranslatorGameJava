package com.mudounet.core;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sentence {
	
	private static final Logger Logger = LoggerFactory
			.getLogger(Sentence.class);
	private ArrayList<AnswerFragment> answerList;
	private String answer;
	
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	private String question;


	public ArrayList<AnswerFragment> getAnswerList() {
		return answerList;
	}
	
	public String getQuestion() {
		return question;
	}



	public void setAnswer(String expectedAnswer) throws MalFormedSentence {
		ArrayList<AnswerFragment> elts = new ArrayList<AnswerFragment>();

		CharSequence cs = new String(expectedAnswer);
		int lastCharType = 0;

		StringBuilder l = new StringBuilder();
		for (int x = 0; x < cs.length(); x++) {
			char myChar = cs.charAt(x);

			int charType;

			if (Character.toString(myChar).matches("[\\p{L}#]"))
				charType = 1;
			else
				charType = 2;

			if (lastCharType == 0)
				lastCharType = charType;

			if (charType != lastCharType) {
				Logger.debug("Found match : \"" + l.toString() + "\"");
				AnswerFragment fragment = new AnswerFragment(l.toString());
				elts.add(fragment);

				l = new StringBuilder();
			}
			l.append(myChar);
			lastCharType = charType;
		}

		Logger.debug("Found last match : \"" + l.toString() + "\"");
		AnswerFragment fragment = new AnswerFragment(l.toString());
		elts.add(fragment);

		this.setAnswerList(elts);
		this.answer = expectedAnswer;
	}

	private void setAnswerList(ArrayList<AnswerFragment> answerList) {
		this.answerList = answerList;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public int getResults() {
		// TODO Auto-generated method stub
		return -1;
	}
}
