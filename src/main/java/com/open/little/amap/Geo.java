package com.open.little.amap;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2018-04-08
 **/

public class Geo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;

    private String info;

    private String infocode;

    private String count;

    private List<Geocodes> geocodes;

    private List<Regeocodes> regeocodes;

    public List<Regeocodes> getRegeocodes() {
        return regeocodes;
    }

    public void setRegeocodes(List<Regeocodes> regeocodes) {
        this.regeocodes = regeocodes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        if (null == this.status){

        }
        return this.status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getInfocode() {
        return this.infocode;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCount() {
        return this.count;
    }

    public List<Geocodes> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<Geocodes> geocodes) {
        this.geocodes = geocodes;
    }
}
