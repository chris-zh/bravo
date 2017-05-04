package cc.jscode.newbravo.biz.config.orm;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by qd on 2017/4/28.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class RdbConfig {

    @Resource
    private DataSource masterDataSource;
    @Resource
    private DataSource slaveADataSource;

    @Resource
    private DataSource slaveBDataSource;


    @Bean("dataSource")
    public DataSource dataSource() {
        DataSource masterSlaveDs0 = MasterSlaveDataSourceFactory.createDataSource("dataSource", masterDataSource, slaveADataSource, slaveBDataSource);
        return ShadingUtil.wrapRwsDatasource(masterSlaveDs0);
    }

}
