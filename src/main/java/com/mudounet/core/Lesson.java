package com.mudounet.core;

import com.mudounet.xml.core.SectionList;
import com.mudounet.xml.stats.MappedTestList;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Lesson {

    private static class TestWithStats {

    public TestWithStats() {
        }
    }
    
    private SectionList sectionList;
    private MappedTestList statList;
    private Map<String, TestWithStats> linkedList;

    private void associateStats() throws Exception {
    }

    public void loadLesson(InputStream lessonStream) throws Exception {
        setSectionList(SectionList.load(lessonStream));
    }

    public void loadStats(InputStream statsStream) throws Exception {
        statList.load(statsStream);
    }

    public void setSectionList(SectionList sectionList) {
        this.sectionList = sectionList;
        setTestStatList(null);
    }

    public void setTestStatList(MappedTestList testStatList) {
        this.statList = testStatList;
        linkedList = new HashMap<String, TestWithStats>();

//        for (int sectionIdx = 0; sectionIdx < list.size(); sectionIdx++) {
//            Section section = list.get(sectionIdx);
//
//            for (int testIdx = 0; testIdx < section.getList().size(); testIdx++) {
//                Test test = section.getList().get(testIdx);
//                this.associatedList.put(sectionIdx + "." + testIdx, test);
//            }
//        }
    }

    public void load(InputStream lessonStream, InputStream testDataStream) throws Exception {
        loadLesson(lessonStream);
        loadStats(testDataStream);
    }
}