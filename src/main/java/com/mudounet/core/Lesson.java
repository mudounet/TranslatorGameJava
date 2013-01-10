package com.mudounet.core;

import com.mudounet.xml.core.Section;
import com.mudounet.xml.core.SectionList;
import com.mudounet.xml.core.Test;
import com.mudounet.xml.stats.TestList;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class Lesson {

    private SectionList lesson;
    private TestList testStatList;

    private void associateStats() throws Exception {


        for (int sectionIdx = 0; sectionIdx < this.lesson.getList().size(); sectionIdx++) {
            Section section = this.lesson.getList().get(sectionIdx);

            for (int testIdx = 0; testIdx < section.getList().size(); testIdx++) {
                Test test = section.getList().get(testIdx);
                test.setStat(testStatList.getItemByKey(sectionIdx + "." + testIdx, true));
            }
        }
        
        for (Entry<String, Test> entry : this.lesson.getAssociatedList().entrySet()) {
            String key = entry.getKey();
            Test test = entry.getValue();

            // do what you have to do here
            // In your case, an other loop.
        }
    }

    public void load(InputStream lessonStream, InputStream testDataStream) throws Exception {
        this.lesson = SectionList.load(lessonStream);
        this.testStatList = TestList.load(testDataStream);
        associateStats();
    }
}