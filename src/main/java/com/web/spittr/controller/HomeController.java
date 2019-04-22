package com.web.spittr.controller;

import com.web.spittr.Spitter;
import com.web.spittr.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/12/13 08:59
 * @Description:  超级简单的控制器
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String login(){
        return "login";
    }

  /*  @RequestMapping(value = "/login", method = GET)
    public String login(){
        return "login";
    }*/

    @RequestMapping(value = "/test", method = GET)
    public String spittlels(Model model) {
        // 将spittle添加到模型中
        // model.addAllAttributes(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        Spittle spittle = new Spittle("Welcome To Spittle!",new Date());
        model.addAttribute("spittle", spittle);
        // 返回视图名
        return "index";
    }


    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "register_form";
    }
}
