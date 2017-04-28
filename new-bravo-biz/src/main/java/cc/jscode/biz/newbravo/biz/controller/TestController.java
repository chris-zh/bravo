package cc.jscode.biz.newbravo.biz.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangxihui@hujiang.com
 * 2017/4/28
 */
@RestController
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}

