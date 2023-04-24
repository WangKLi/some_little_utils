package com.open.little.amap;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class BcMessage implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 消息事件类型
     */
    private String messageEventType;

    /**
     * 消息详情ID
     */
    private Long messageDetailId;

    /**
     * 消息接收者手机号
     */
    private String phoneCode;

    /**
     * 消息接收者名字
     */
    private String userName;

    /**
     * 消息接收者id
     */
    private Long userId;

    /**
     * 消息状态 1.已读 0.未读
     */
    private String status;

    /**
     * 消息发送者id
     */
    private Long createdBy;

    /**
     * 消息发送日期
     */
    private Date createdDt;

    /**
     * 消息更新者id
     */
    private Long updatedBy;

    /**
     * 消息更新日期
     */
    private Date updatedDt;

    /**
     * 备注
     */
    private String remark;

    /**
     * 消息标题
     */
    private String messageTitle;

    /**
     * 站点名称
     * @return
     */
    private String siteName;

    /**
     * 货物名称
     * @return
     */
    private String goodsName;
    /**
     * 类别（C1:通知类、C2：活动类、C3:系统类）
     */
    private String messageClassType;


}