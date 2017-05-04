package cc.jscode.newbravo.biz.config.orm;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.NoneDatabaseShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.NoneTableShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.google.common.base.Throwables;

import javax.sql.DataSource;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qd on 2017/5/1.
 */
public class ShadingUtil {
    public static DataSource wrapRwsDatasource(DataSource... dataSources){
        Map<String, DataSource> dataSourceMap = new HashMap<>(dataSources.length);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(DataSource dataSource : dataSources) {
            dataSourceMap.put("ds_" + atomicInteger.getAndIncrement(), dataSource);
        }
        TableRule tableRule = TableRule.builder("mock").actualTables(Arrays.asList("mock")).build();

        List<TableRule> tableRules = new ArrayList<>();
        tableRules.add(tableRule);
        ShardingRule shardingRule = ShardingRule
                .builder()
                .dataSourceRule(new DataSourceRule(dataSourceMap))
                .databaseShardingStrategy(new DatabaseShardingStrategy("_none_db", new NoneDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("_none_table", new NoneTableShardingAlgorithm()))
                .tableRules(tableRules)
                .build();
        return ShardingDataSourceFactory.createDataSource(shardingRule);

    }
}
