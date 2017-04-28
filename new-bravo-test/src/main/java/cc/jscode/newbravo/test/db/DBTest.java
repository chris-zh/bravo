package cc.jscode.newbravo.test.db;

import cc.jscode.newbravo.test.config.BaseTestConfig;
import cc.jscode.newbravo.test.env.ActiveEnvironment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by qd on 2017/4/28.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseTestConfig.class, ActiveEnvironment.DEV.class})
public class DBTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        String sql  = "select * from movie";
        List list = jdbcTemplate.queryForList(sql);
        System.out.println("list = " + list);
    }

    @Test
    public void test2() {
        String sql = "insert into movie (name) values('test')";
        jdbcTemplate.update(sql);
    }
}
