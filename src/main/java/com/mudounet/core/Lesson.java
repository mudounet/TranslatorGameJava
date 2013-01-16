package com.mudounet.core;

import com.mudounet.xml.core.MappedSectionList;
import com.mudounet.xml.stats.MappedTestList;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Lesson {
    protected MappedSectionList sectionList = new MappedSectionList();
    protected MappedTestList statList = new MappedTestList();
    protected Map<String, Sentence> linkedList;
    protected float initialStat = 0.0f;

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

        linkedList = new HashMap<String, Sentence>();
        for(String key : this.sectionList.getLinkedList().keySet()) {
            linkedList.put(key, new Sentence(this.sectionList.getItemByKey(key), this.statList.getItemByKey(key, true)));
        }
        this.initialStat = getStat();
    }
    
    public Sentence getNextSentence() throws MalFormedSentence {
        
        String selectedKey = this.statList.getSelectedStat().getKey();
        return this.linkedList.get(selectedKey);
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