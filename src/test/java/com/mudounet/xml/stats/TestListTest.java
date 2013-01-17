/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.xml.stats;

import com.mudounet.core.ResourceManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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
        assertEquals(100 / 3f, instance.mean(), 1f);

        t = new TestStat();
        t.addResult(100f);
        instance.getList().add(t);
        assertEquals(((100 / 3) + 100) / 2, instance.mean(), 1f);

        t.addResult(0);
        assertEquals(((100 / 3) + 50) / 2, instance.mean(), 1f);

        t.addResult(0);
        assertEquals(((100 / 3) + (100 / 3)) / 2, instance.mean(), 1f);
    }

    /**
     * Test of save method, of class TestList.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        OutputStream stream = null;
        TestList instance = new TestList();
        instance.save(stream);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class TestList.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        InputStream stream = null;
        TestList instance = new TestList();
        instance.load(stream);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedStat method, of class TestList.
     */
    @Test
    public void testGetSelectedStat() {
        System.out.println("getSelectedStat");
        TestList instance = new TestList();
        TestStat expResult = null;
        TestStat result = instance.getSelectedStat();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedStat method, of class TestList.
     */
    @Test
    public void testOrderingStats() throws Exception {
        System.out.println("getSelectedStat");
        TestList instance = new TestList();
        instance.load(ResourceManager.LoadFile("/lessons-test.stats"));

        ArrayList<String> listRefs = new ArrayList();
        listRefs.add("1.1");
        listRefs.add("0.1");
        listRefs.add("2.3");
        listRefs.add("2.2");
        listRefs.add("1.0");
        listRefs.add("2.0");
        listRefs.add("2.1");
        listRefs.add("0.0");

        assertNotNull(instance.list);
        assertEquals(listRefs.size(), instance.list.size());

        for (int currentOrder = 0; currentOrder < listRefs.size(); currentOrder++) {
            assertNotEquals(listRefs.get(currentOrder), instance.list.get(currentOrder).getKey());
        }

        instance.getSelectedStat();

        for (int currentOrder = 0; currentOrder < listRefs.size(); currentOrder++) {
            assertEquals(listRefs.get(currentOrder), instance.list.get(currentOrder).getKey());
        }
    }
}
