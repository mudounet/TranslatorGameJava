package com.mudounet.xml.stats;

import java.util.Date;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class TestStat implements Comparable<TestStat> {

    @Attribute
    private String key = "";
    
    @Attribute
    private int failed = 0;
    @Attribute
    private int total = 0;
    @Attribute
    private Date lastUpdate = new Date(0);
    @Attribute
    private Date lastFailed = new Date(0);
    @Attribute
    private MeanList lastResults = new MeanList();

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public Date getLastFailed() {
        return lastFailed;
    }

    public void setLastFailed(Date lastFailed) {
        this.lastFailed = lastFailed;
    }

    public MeanList getLastResults() {
        return lastResults;
    }

    public void setLastResults(MeanList lastResults) {
        this.lastResults = lastResults;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int compareTo(TestStat o) {
        // TODO Auto-generated method stub
        if (this.lastResults.mean() < o.lastResults.mean()) {
            return -1;
        }
        if (this.lastResults.mean() > o.lastResults.mean()) {
            return 1;
        }
        if (this.total < o.total) {
            return -1;
        }
        if (this.total > o.total) {
            return 1;
        }
        return 0;
    }

    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
}
