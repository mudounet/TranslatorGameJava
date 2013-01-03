package com.mudounet.core;

public class QuestionFragment {
	public static final int EDITABLE_FRAGMENT = 1;
	public static final int CONSTANT_FRAGMENT = 2;
	
	private int fragmentType;
	private String questionText;
	
	/**
	 * @return the fragmentType
	 */
	public int getFragmentType() {
		return fragmentType;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return questionText;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.questionText = text;
		this.fragmentType = CONSTANT_FRAGMENT;
	}
	
	public QuestionFragment(String text) {
		setText(text);
	}

	private int computeLevenshtein(String answerText) {
		// TODO Auto-generated method stub
		return -1;
	}
	
}
