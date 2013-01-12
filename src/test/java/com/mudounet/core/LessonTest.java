/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.core;

import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author isabelle
 */
public class LessonTest {
    
    public LessonTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of load method, of class Lesson.
     * @throws Exception 
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        String lesson = "";
        String testData = "";
        Lesson instance = new Lesson();
        instance.load(ResourceManager.LoadFile("/lessons.xml"), ResourceManager.LoadFile("/lessonStats.xml"));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
