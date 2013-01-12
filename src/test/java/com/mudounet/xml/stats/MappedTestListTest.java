/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.xml.stats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author isabelle
 */
public class MappedTestListTest {
    
    MappedTestList instance;

    @Before
    public void setUp() throws Exception {
        instance = new MappedTestList();
        instance.load(new FileInputStream("teststream.xml"));
    }

    /**
     * Test of getLinkedList method, of class MappedTestList.
     */
    @Test
    public void testGetLinkedList() {
        System.out.println("getLinkedList");
        MappedTestList instance = new MappedTestList();
        Map expResult = null;
        Map result = instance.getLinkedList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemByKey method, of class MappedTestList.
     */
    @Test
    public void testGetItemByKey() throws Exception {
        System.out.println("getItemByKey");
        String key = "";
        boolean autocreate = false;
        MappedTestList instance = new MappedTestList();
        TestStat expResult = null;
        TestStat result = instance.getItemByKey(key, autocreate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTestStat method, of class MappedTestList.
     */
    @Test
    public void testCreateTestStat() throws Exception {
        System.out.println("createTestStat");
        String key = "";
        MappedTestList instance = new MappedTestList();
        instance.createTestStat(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setList method, of class MappedTestList.
     */
    @Test
    public void testSetList() {
        System.out.println("setList");
        List<TestStat> list = null;
        MappedTestList instance = new MappedTestList();
        instance.setList(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class MappedTestList.
     * @throws Exception 
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        FileInputStream stream = new FileInputStream("/teststream.xml");
        //instance.load(stream);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
