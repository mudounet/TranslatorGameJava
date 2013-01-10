package com.mudounet.xml.stats;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Root
public class TestList {

    private static final Logger Logger = LoggerFactory.getLogger(TestList.class);
    @ElementList(inline = true)
    private List<TestStat> list = new ArrayList<TestStat>();

    public void setList(List<TestStat> list) {
        this.list = list;

        associatedList = new HashMap<String, TestStat>();
        for (TestStat stat : list) {
            associatedList.put(stat.getKey(), stat);
        }
    }
    Map<String, TestStat> associatedList;

    public Map<String, TestStat> getAssociatedList() {
        return associatedList;
    }

    public TestList() {
    }

    /**
     * @return the list
     */
    public List<TestStat> getList() {
        return list;
    }

    public void createTestStat(String key) throws Exception {
        if (associatedList.containsKey(key)) {
            Logger.error("Key \"" + key + " is already inserted.");
            throw new Exception("Key \"" + key + " is already inserted.");
        }

        TestStat t = new TestStat();
        t.setKey(key);
        list.add(t);

        associatedList.put(key, t);
    }

    public TestStat getItemByKey(String key, boolean autocreate) throws Exception {
        if (!associatedList.containsKey(key) && autocreate) {
            Logger.debug("Key \"" + key + " will be created automatically.");
            this.createTestStat(key);
        }

        return associatedList.get(key);
    }

    public boolean save(OutputStream stream) {
        // TODO Auto-generated method stub
        return false;
    }

    public TestStat selectNextTest() {
        Collections.sort(list);
        return null;
    }

    public static TestList load(InputStream stream) throws Exception {
        Serializer serializer = new Persister();
        return serializer.read(TestList.class, stream);
    }

    public int displayGlobalStats() {
        // TODO Auto-generated method stub
        return -1;
    }
}
