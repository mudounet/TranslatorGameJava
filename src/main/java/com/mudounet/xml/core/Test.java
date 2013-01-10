package com.mudounet.xml.core;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Test {

	@Element
	private String question;
	
	@Element
	private String answer;
	
	private com.mudounet.xml.stats.TestStat stat;

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public com.mudounet.xml.stats.TestStat getStat() {
		return stat;
	}

	public void setStat(com.mudounet.xml.stats.TestStat stat) {
		this.stat = stat;
	}
}
