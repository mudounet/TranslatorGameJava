/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.xml.stats;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mudounet
 */
public class TestListTest {
    
    public TestListTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of mean method, of class TestList.
     */
    @Test
    public void testMean() {
        System.out.println("mean");
        TestList instance = new TestList();
        float expResult = 0.0F;
        assertEquals(expResult, instance.mean(), 0.0);
        
        TestStat t = new TestStat();
        t.addResult(100f);
        instance.getList().add(t);
        assertEquals(100, instance.mean(), 0.001f);
        
        t.addResult(0.0f);
        assertEquals(50, instance.mean(), 0.001f);
        
        t.addResult(0.0f);
        assertEquals(100/3f, instance.mean(), 1f);
        
        t = new TestStat();
        t.addResult(100f);
        instance.getList().add(t);
        assertEquals(((100/3)+100)/2, instance.mean(), 1f);
        
        t.addResult(0);
        assertEquals(((100/3)+50)/2, instance.mean(), 1f);
        
        t.addResult(0);
        assertEquals(((100/3)+(100/3))/2, instance.mean(), 1f);
    }
}
