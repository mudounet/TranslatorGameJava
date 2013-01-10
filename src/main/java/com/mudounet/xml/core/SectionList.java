package com.mudounet.xml.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class SectionList {

    @ElementList(inline = true)
    private List<Section> list;
    private Map<String, Test> associatedList;

    public Map<String, Test> getAssociatedList() {
        return associatedList;
    }

    /**
     * @return the list
     */
    public List<Section> getList() {
        return list;
    }

    public Test getItemByKey(String key) throws Exception {
        return associatedList.get(key);
    }

    /**
     * @param stream stream to read from
     * @throws Exception
     */
    public static SectionList load(InputStream stream) throws Exception {
        Serializer serializer = new Persister();
        return serializer.read(SectionList.class, stream);


    }

    private void load2(InputStream stream) {
        associatedList = new HashMap<String, Test>();
        for (int sectionIdx = 0; sectionIdx < list.size(); sectionIdx++) {
            Section section = list.get(sectionIdx);

            for (int testIdx = 0; testIdx < section.getList().size(); testIdx++) {
                Test test = section.getList().get(testIdx);
                this.associatedList.put(sectionIdx+"."+testIdx, test);
            }
        }
    }

    /**
     * @param stream stream to write to
     * @throws Exception
     */
    public static void save(SectionList list, OutputStream stream) throws Exception {
        Serializer serializer = new Persister();
        serializer.write(list, stream);
    }
}
