package com.web.spittr;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/13 08:59
 * @Description:  超级简单的控制器
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String home(){
        return "home";
    }
}
