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
    protected List<TestStat> list = new ArrayList<TestStat>();

    public void setList(List<TestStat> list) {
        this.list = list;
    }
    
    /**
     * @return the list
     */
    public List<TestStat> getList() {
        return list;
    }

    public void save(OutputStream stream) throws Exception {
        Serializer serializer = new Persister();
        serializer.write(this, stream);
    }

    public void load(InputStream stream) throws Exception {
        Serializer serializer = new Persister();
        TestList t = serializer.read(TestList.class, stream);
        this.list = t.list;
    }
}
