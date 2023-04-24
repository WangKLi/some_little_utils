package com.open.little.amap;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: 逆地理位置查询
 *
 * @author liujianwen@sinochem.com
 * @create 2018-07-12
 */
@Data
public class Regeocodes implements Serializable {
    private static final long serialVersionUID = -1277264863027386220L;
    /**
     * 结构化地址信息
     */
    private String formatted_address;
}
