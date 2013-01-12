/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mudounet.xml.stats;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author isabelle
 */
public class MappedTestList extends TestList {

    private static final Logger Logger = LoggerFactory.getLogger(MappedTestList.class);
    private Map<String, TestStat> linkedList = new HashMap<String, TestStat>();
    
    public Map<String, TestStat> getLinkedList() {
        return linkedList;
    }
    
    public TestStat getItemByKey(String key, boolean autocreate) throws Exception {
        if (!linkedList.containsKey(key) && autocreate) {
            Logger.debug("Key \"" + key + " will be created automatically.");
            this.createTestStat(key);
        }

        return linkedList.get(key);
    }

    public void createTestStat(String key) throws Exception {
        if (linkedList.containsKey(key)) {
            Logger.error("Key \"" + key + " is already inserted.");
            throw new Exception("Key \"" + key + " is already inserted.");
        }

        TestStat t = new TestStat();
        t.setKey(key);
        this.getList().add(t);

        linkedList.put(key, t);
    }

    
    private void buildLinkedList() {
        this.linkedList = new HashMap<String, TestStat>();
        
    }

    @Override
    public void setList(List<TestStat> list) {
        super.setList(list);
        buildLinkedList();
    }

    @Override
    public void load(InputStream stream) throws Exception {
        super.load(stream);
        this.setList(this.getList());
    }
}
