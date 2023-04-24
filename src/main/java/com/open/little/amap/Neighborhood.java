package com.open.little.amap;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2018-04-08
 **/

public class Neighborhood implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Name> name;

    private List<Type> type;

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Name> getName() {
        return this.name;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public List<Type> getType() {
        return this.type;
    }
}
