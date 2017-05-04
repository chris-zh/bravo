package cc.jscode.newbravo.biz.config.orm;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by qd on 2017/4/28.
 */
@SuppressWarnings("ALL")
@Configuration
@MapperScan("cc.jscode.newbravo.dao.mapper")
@AutoConfigureAfter(RdbConfig.class)
public class MybatisConfig {
    @Resource(name = "dataSource")
    private DataSource shardingDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory(MybatisProperties mybatisProperties) throws Exception {
        org.apache.ibatis.session.Configuration configuration = mybatisProperties.getConfiguration();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(shardingDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mybatisProperties.getMapperLocations()[0]));
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();

    }

}
