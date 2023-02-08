package com.open.little.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taiyuan.work.fitment.b2c.config.ThreadResources;
import com.taiyuan.work.fitment.b2c.config.ThreadResourcesKey;

/**
 * @Title: 根据http请求头智能获取json转换器（两种风格:下划线风格的转换器和非下划线风格的转换器 ）
 * @author ning.li
 * @version 2016-03-08
 */
public class ObjectMapperProvider {

	/**
	 * null为空
	 */
	private ObjectMapper  nullObjectMapper;

	/**
	 * null转空字符串
	 */
	private ObjectMapper nullToStringObjectMapper;



	public ObjectMapper getObjectMapper() {
		String jsonStyle=(String) ThreadResources.getResource(ThreadResourcesKey.JSON_STYLE);
		if("nullStyle".equalsIgnoreCase(jsonStyle)){
			return nullObjectMapper;
		}else{
			return nullToStringObjectMapper;
		}
	}

	public void setNullObjectMapper(ObjectMapper nullObjectMapper) {
		this.nullObjectMapper = nullObjectMapper;
	}

	public void setNullToStringObjectMapper(ObjectMapper nullToStringObjectMapper) {
		this.nullToStringObjectMapper = nullToStringObjectMapper;
	}
}
