/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.core;

import java.io.FileOutputStream;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author isabelle
 */
public class LessonTest {
   
    
    @Before
    public void setUp() throws Exception {
        instance = new Lesson(ResourceManager.LoadFile("/lessons.xml"));
    }
    
    Lesson instance;

    /**
     * Test of loadLesson method, of class Lesson.
     */
    @Test
    public void testLoadLesson() throws Exception {
        System.out.println("TEST : loadLesson");
        instance.loadLesson(ResourceManager.LoadFile("/lessons.xml"));
    }

    /**
     * Test of loadStats method, of class Lesson.
     */
    @Test
    public void testLoadStats() throws Exception {
        System.out.println("TEST : loadStats");
        Sentence s;
        
        instance.loadStats(null);
        
        assertEquals(0, instance.getInitialStat(), 0.001f);
        assertEquals(0, instance.getStat(), 0.001f);
        
        s = instance.getNextSentence();
        s.getStat().addStat(100f);
        
        assertEquals(0, instance.getInitialStat(), 0.001f);
        float currentValue = instance.getStat();
        assertTrue(currentValue > 0.0f);
        
        instance.saveStats(new FileOutputStream("lesson-stats.xml"));
        instance.loadStats(ResourceManager.LoadFile("lesson-stats.xml"));
        
        assertEquals(currentValue, instance.getInitialStat(), 0.001f);
        assertTrue(instance.getStat() > 0.0f);
        
        assertEquals(25, instance.getInitialStat());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextSentence method, of class Lesson.
     */
    @Test
    public void testGetNextSentence() throws MalFormedSentence {
        System.out.println("getNextSentence");
        Sentence expResult = null;
        Sentence result = instance.getNextSentence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveStats method, of class Lesson.
     */
    @Test
    public void testSaveStats() throws Exception {
        System.out.println("TEST : saveStats");
        instance.saveStats(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
