package cc.jscode.newbravo.biz.config.orm;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by qd on 2017/4/28.
 */
@Configuration
@EnableConfigurationProperties
public class DataSourceConfig {


    @Bean(name = "masterDataSource", initMethod = "init", destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix="datasource.master.druid")
    public DruidDataSource masterDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "slaveADataSource", initMethod = "init", destroyMethod = "close")

    @ConfigurationProperties(prefix="datasource.slave.a.druid")
    public DruidDataSource slaveADataSource() {
        return new DruidDataSource();
    }
    @Bean(name = "slaveBDataSource", initMethod = "init", destroyMethod = "close")
//    @Primary
    @ConfigurationProperties(prefix="datasource.slave.b.druid")
    public DruidDataSource slaveBDataSource() {
        return new DruidDataSource();
    }
}
