package com.open.little.amap;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2018-04-08
 **/

public class Building implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<String> name;

    private List<String> type;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
