package cc.jscode.newbravo.biz.config.web;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;

/**
 * Created by qd on 2017/4/28.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Value("${spring.mvc.date-format:yyyy-MM-dd'T'HH:mm:ss}")
    private String dataFormat;

    /**
     * 使用fastJson作为序列化转换器
     * @return
     */
    @Bean
    public HttpMessageConverter httpMessageConverter() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        fastJsonConfig.setFeatures(Feature.AllowUnQuotedFieldNames, Feature.AllowSingleQuotes);
        fastJsonConfig.setDateFormat(dataFormat);
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setFastJsonConfig(fastJsonConfig);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        return converter;
    }

    /**
     * 设置URL匹配规则
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }
}
