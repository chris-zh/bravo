package cc.jscode.newbravo.biz.controller;


import cc.jscode.newbravo.dao.mapper.MovieDao;
import cc.jscode.newbravo.model.po.MoviePo;
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

    @Autowired
    private MovieDao dao;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public MoviePo test() {
//        String sql = "select * from movie";
//        List<Map<String, Object>> po  = jdbcTemplate.queryForList(sql);
//        System.out.println("po = " + po);
        MoviePo po2 = dao.queryById(1);
        System.out.println("po2 = " + po2);
        return po2;
    }
}

