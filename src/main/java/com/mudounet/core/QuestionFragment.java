package com.mudounet.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionFragment {
	
	private static final Logger Logger = LoggerFactory.getLogger(QuestionFragment.class); 
	public static final int EDITABLE_FRAGMENT = 1;
	public static final int CONSTANT_FRAGMENT = 2;

	private int fragmentType;
	private String question;
	private String answer;

	public QuestionFragment(String text) throws Exception {
		setQuestion(text);
	}

	public QuestionFragment() {
	}

	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	private int computeLevenshteinDistance() {
		if (fragmentType == CONSTANT_FRAGMENT) {
			return 0;
		}

		CharSequence str1 = new String(this.question.toLowerCase());
		CharSequence str2 = new String(this.answer.toLowerCase());
		Logger.debug("Compute \""+ str1 + "\" with \"" + str2 +"\"");
		

		int[][] distance = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= str2.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++)
				distance[i][j] = minimum(
						distance[i - 1][j] + 1,
						distance[i][j - 1] + 1,
						distance[i - 1][j - 1]
								+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
										: 1));

		return distance[str1.length()][str2.length()];
	}

	
	public int validate() {
		return computeLevenshteinDistance();
	}

	/**
	 * @return the fragmentType
	 */
	public int getFragmentType() {
		return fragmentType;
	}

	/**
	 * @return the text
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param text
	 *            the text to set
	 * @throws Exception 
	 */
	public void setQuestion(String text) throws Exception {
		
		this.fragmentType = 0;
		Pattern patt = Pattern.compile("^#(\\p{L}+)$");
		Matcher m = patt.matcher(text);
		
		if(text.matches("^\\p{L}+$")) {
			this.fragmentType = EDITABLE_FRAGMENT;
			this.question = text;
			setAnswer("");
		}
		else if(m.matches()) {
			this.fragmentType = CONSTANT_FRAGMENT;
			this.question = m.group(1);
			setAnswer(this.question);
		} 
		else if(text.matches("^\\P{L}+$")) {
			this.fragmentType = CONSTANT_FRAGMENT;
			this.question = text;
			setAnswer(this.question);
		}
		else {
			Logger.error("\""+ text + "\" is not valid!");
			throw new Exception("\""+ text + "\" is not valid!");
		}
		
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answerText) {
		if (this.fragmentType == EDITABLE_FRAGMENT)
			this.answer = answerText;
		else
			this.answer = this.question;
	}
}
