package cc.jscode.newbravo.biz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxihui@hujiang.com
 * 2017/4/28
 */
@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public List test() {
        String sql = "select * from movie";
        List<Map<String, Object>> po  = jdbcTemplate.queryForList(sql);
        System.out.println("po = " + po);
        return po;
    }
}

