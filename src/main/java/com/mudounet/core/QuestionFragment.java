package com.mudounet.core;

public class QuestionFragment {
	public static final int EDITABLE_FRAGMENT = 1;
	public static final int CONSTANT_FRAGMENT = 2;

	private int fragmentType;
	private String question;
	private String answer;

	public QuestionFragment(String text) {
		setQuestion(text);
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
	 */
	private void setQuestion(String text) {
		this.question = text;
		this.setAnswer("");
		this.fragmentType = EDITABLE_FRAGMENT;
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
