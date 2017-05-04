package cc.jscode.newbravo.biz.controller;


import cc.jscode.newbravo.dao.mapper.MovieDao;
import cc.jscode.newbravo.model.po.MoviePo;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangxihui@hujiang.com
 * 2017/4/28
 */
@RestController
public class TestController {

    private  AtomicInteger num = new AtomicInteger(1);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MovieDao dao;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public List test() {
//        String sql = "select * from movie";
//        List<Map<String, Object>> po  = jdbcTemplate.queryForList(sql);
//        System.out.println("po = " + po);
        MoviePo po2 = dao.queryById(2);
        System.out.println("po2 = " + po2);
        List<MoviePo> list = dao.queryAll();
        return list;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public int add() {
        MoviePo po = new MoviePo();
        po.setName("测试"+num.getAndIncrement());
        po.setReferrer("chris.zhang");
        return dao.insert(po);

    }
}

