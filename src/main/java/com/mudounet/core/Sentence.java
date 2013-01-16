package com.mudounet.core;

import com.mudounet.xml.core.Test;
import com.mudounet.xml.stats.TestStat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Sentence {

    private static final Logger Logger = LoggerFactory
            .getLogger(Sentence.class);
    private ArrayList<AnswerFragment> answerList;
    private String answer;
    private TestStat stat;
    private Test test;

    public Sentence(Test test, TestStat stat) throws MalFormedSentence {
        this.setTest(test);
        this.setStat(stat);
    }

    public Sentence() {
    }

    public ArrayList<AnswerFragment> getAnswerList() {
        return answerList;
    }

    private void setAnswerList(String expectedAnswer) throws MalFormedSentence {
        ArrayList<AnswerFragment> elts = new ArrayList<AnswerFragment>();

        CharSequence cs = new String(expectedAnswer);
        int lastCharType = 0;

        StringBuilder l = new StringBuilder();
        for (int x = 0; x < cs.length(); x++) {
            char myChar = cs.charAt(x);

            int charType;

            if (Character.toString(myChar).matches("[\\p{L}#]")) {
                charType = 1;
            } else {
                charType = 2;
            }

            if (lastCharType == 0) {
                lastCharType = charType;
            }

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

        this.answerList = elts;
        this.answer = expectedAnswer;
    }

    public int getResults() {
        throw new NotImplementedException();
    }

    public TestStat getStat() {
        return stat;
    }

    public void setStat(TestStat stat) {
        this.stat = stat;
    }

    public void setTest(Test test) throws MalFormedSentence {
        this.test = test;
        this.setAnswerList(test.getAnswer());
    }

    public void addResult(float f) {
        this.stat.addResult(f);
    }
}
