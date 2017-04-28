package cc.jscode.newbravo.test.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 环境激活
 * @author chris.zhang
 */
public class ActiveEnvironment {

    /**
     * 开发环境
     */
    @Configuration
    @PropertySource("classpath:config/application-dev.properties")
    public static class DEV{}

    /**
     * QA环境
     */
    @Configuration
    @PropertySource("classpath:config/application-qa.properties")
    public static class QA{}

    /**
     * 压测环境
     */
    @Configuration
    @PropertySource("classpath:config/application-prs.properties")
    public static class PRS{}

    /**
     * 预发环境
     */
    @Configuration
    @PropertySource("classpath:config/application-stg.properties")
    public static class STG{}

    /**
     * 产线环境
     */
    @Configuration
    @PropertySource("classpath:config/application-prd.properties")
    public static class PRD{}
}
