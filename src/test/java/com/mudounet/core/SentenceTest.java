package com.mudounet.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SentenceTest {

    Sentence questionTested;

    @Before
    public void setup() {
        questionTested = new Sentence();
    }

    /**
     * Test method for {@link com.mudounet.core.Question#getAnswerList()}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAnswerList() throws Exception {
        testGetAnswerListValidation("Как по-французски \"конечно\"?", new String[]{"Как", " ", "по", "-", "французски", " \"", "конечно", "\"?"});
        testGetAnswerListValidation("#Вы замужем? - #Да, замужем.", new String[]{"Вы", " ", "замужем", "? - ", "Да", ", ", "замужем", "."});
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
        com.mudounet.xml.core.Test t = new com.mudounet.xml.core.Test();
        t.setAnswer(expectedAnswer);

        questionTested.setTest(t);
        ArrayList<AnswerFragment> elements = questionTested.getAnswerList();

        for (int idx = 0; idx < answers.length; idx++) {
            assertEquals(answers[idx], elements.get(idx).getQuestion());
        }
    }
}
