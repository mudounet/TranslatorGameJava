package com.mudounet.core;

import com.mudounet.xml.core.MappedSectionList;
import com.mudounet.xml.core.Test;
import com.mudounet.xml.stats.MappedTestList;
import com.mudounet.xml.stats.TestStat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Lesson {

    private static class TestWithStats {

        public Test test;
        public TestStat stat;

        public TestWithStats(Test test, TestStat stat) {
            this.test = test;
            this.stat = stat;
        }

        private TestWithStats() {
        }
    }
    private MappedSectionList sectionList = new MappedSectionList();
    private MappedTestList statList = new MappedTestList();
    private Map<String, TestWithStats> linkedList;
    private float initialStat = 0.0f;

    public Lesson(InputStream lessonStream) throws Exception {
        loadLesson(lessonStream);
    }

    
    
    public void loadLesson(InputStream lessonStream) throws Exception {
        sectionList.load(lessonStream);
        setTestStatList(null);
    }

    public void loadStats(InputStream statsStream) throws Exception {
        statList.load(statsStream);

        setTestStatList(statList);
    }

    private void setTestStatList(MappedTestList testStatList) throws Exception {
        this.statList = testStatList;
        if (this.statList == null || this.statList.getLinkedList() == null) {
            this.statList = new MappedTestList();
        }

        linkedList = new HashMap<String, TestWithStats>();
        for(String key : this.sectionList.getLinkedList().keySet()) {
            linkedList.put(key, new TestWithStats(this.sectionList.getItemByKey(key), this.statList.getItemByKey(key, true)));
        }
        this.initialStat = getStat();
    }
    
    public Sentence getNextSentence() throws MalFormedSentence {
        
        String selectedKey = this.statList.getSelectedStat().getKey();
        TestWithStats testWithStats = this.linkedList.get(selectedKey);
        
        
        
        Sentence s = new Sentence();
        s.setTest(testWithStats.test);
        s.setStat(testWithStats.stat);
        return s;
    }
    
    public float getInitialStat() {
        return this.initialStat;  
    }
    
    public float getStat() {
        return this.statList.mean();  
    }
    
    public void saveStats(OutputStream outputStream) throws Exception {
        this.statList.save(outputStream);
    }
}