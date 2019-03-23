package com.leiye;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试首页
 * @author ucs_yelei
 *
 */
@Controller
public class IndexController
{
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
}