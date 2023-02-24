package com.open.little.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: OssConfig
 * @Description: 阿里云oss 配置
 * @Date: 2022/12/6 10:20
 */
@Configuration
@ConfigurationProperties(prefix = "config.oss")
@Data
public class OssConfig {

    private String regionId;
    private String endpoint;
    private String bucketName;
    private String writeAccessKeyId;
    private String writeAccessKeySecret;
    private String readAccessKeyId;
    private String readAccessKeySecret;
    private String roleArn;
    private String roleSessionName;

    private String permanentPath;

}
