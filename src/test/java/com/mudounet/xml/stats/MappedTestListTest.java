/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.xml.stats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        instance.createTestStat("0.1");
        instance.createTestStat("0.2");
        instance.createTestStat("1.1");
        instance.createTestStat("1.2");
        instance.createTestStat("2.1");
        instance.createTestStat("2.2");
    }

    /**
     * Test of getLinkedList method, of class MappedTestList.
     */
    @Test
    public void testGetLinkedList() {
        System.out.println("TEST : getLinkedList");
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
        System.out.println("TEST : getItemByKey");
        String key = "0.1";
        TestStat expResult = new TestStat();
        expResult.setKey(key);
        TestStat result = instance.getItemByKey(key, false);
        assertEquals(expResult.getKey(), result.getKey());
        
        key = "4.1";
        expResult.setKey(key);
        result = instance.getItemByKey(key, false);
        assertNull(result);
        
        result = instance.getItemByKey(key, true);
        assertEquals(expResult.getKey(), result.getKey());
    }

    /**
     * Test of createTestStat method, of class MappedTestList.
     */
    @Test
    public void testCreateTestStat() throws Exception {
        System.out.println("TEST : createTestStat");
        String key = "3.1";
        
        assertNull(instance.getItemByKey("3.1", false));
        instance.createTestStat(key);
        assertNotNull(instance.getItemByKey("3.1", false));
    }
    
    @Test(expected=Exception.class)
    public void testCreateTestStatwithError() throws Exception {
        System.out.println("TEST : createTestStat With Exception");
        String key = "2.1";
        instance.createTestStat(key);
    }

    /**
     * Test of setList method, of class MappedTestList.
     */
    @Test
    public void testSetList() {
        System.out.println("TEST : setList");

        assertEquals(6, instance.getList().size());
        assertEquals(instance.getList().size(), instance.getLinkedList().keySet().size());
        
        List<TestStat> list = null;
        instance.setList(list);
        assertNull(instance.getList());
        assertNull(instance.getLinkedList());
        
        list = new ArrayList<TestStat>();
        instance.setList(list);
        assertEquals(0, instance.getList().size());
        assertEquals(instance.getList().size(), instance.getLinkedList().keySet().size());
        
        TestStat t = new TestStat();
        t.setKey("0.1");
        
        list.add(t);
        assertEquals(0, instance.getList().size());
        assertEquals(instance.getList().size(), instance.getLinkedList().keySet().size());

        instance.setList(list);
        assertEquals(1, instance.getList().size());
        assertEquals(instance.getList().size(), instance.getLinkedList().keySet().size());
    }

    /**
     * Test of load method, of class MappedTestList.
     * @throws Exception 
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("TEST : load");
        
        assertEquals(6, instance.getList().size());
        instance.save(new FileOutputStream("teststream.xml"));
        instance = new MappedTestList();
        assertEquals(0, instance.getList().size());
        
        
        FileInputStream stream = new FileInputStream("teststream.xml");
        instance.load(stream);
        assertEquals(6, instance.getList().size());
    }
}
