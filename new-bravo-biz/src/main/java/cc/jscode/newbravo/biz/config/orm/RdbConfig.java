package cc.jscode.newbravo.biz.config.orm;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.NoneDatabaseShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.NoneTableShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;

/**
 * Created by qd on 2017/4/28.
 */
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class RdbConfig {

    @Resource
    private DataSource dataSource_master;
    @Resource
    private DataSource dataSource_slave_a;

    @Resource
    private DataSource dataSource_slave_b;

    @Bean
    public DataSource dataSource() {
        DataSource masterSlaveDs0 = MasterSlaveDataSourceFactory.createDataSource("ds_", dataSource_master, dataSource_slave_a, dataSource_slave_b);
        // 构建分库分表数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("ds_", masterSlaveDs0);

        TableRule tableRule = TableRule.builder("mock").actualTables(Arrays.asList("mock")).build();
        List<TableRule> tableRules = new ArrayList<>();
        tableRules.add(tableRule);

        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(new DataSourceRule(dataSourceMap))
                .databaseShardingStrategy(new DatabaseShardingStrategy("_none_db", new NoneDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("_none_table", new NoneTableShardingAlgorithm()))
                .tableRules(tableRules)
                .build();
        ShardingDataSourceFactory.createDataSource(shardingRule);
        return masterSlaveDs0;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }


}
