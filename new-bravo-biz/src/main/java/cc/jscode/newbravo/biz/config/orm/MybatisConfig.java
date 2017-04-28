package cc.jscode.newbravo.biz.config.orm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qd on 2017/4/28.
 */
@Configuration
@MapperScan("cc.jscode.newbravo.dao.mapper")
public class MybatisConfig {
}
