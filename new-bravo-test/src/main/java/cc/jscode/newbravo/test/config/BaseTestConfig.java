package cc.jscode.newbravo.test.config;

import org.jscode.bravo.BootLauncher;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by qd on 2017/4/28.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"cc.jscode.newbravo"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BootLauncher.class}),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "cc.jscode.newbravo.test.*")//测试环境配置等排除
        })
public class BaseTestConfig {

}
