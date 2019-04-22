/**
 * 文件名: SpittleController.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.controller;

import com.web.spittr.Spitter;
import com.web.spittr.Spittle;
import com.web.spittr.data.SpittleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.AuthorizationData;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-28 11:24
 */
@Controller
@RequestMapping("/spittle")
@SessionAttributes("spitter")
@Slf4j
public class SpittleController {
    public static final Long MAX_VALUE = Long.MAX_VALUE;
    public static final int DEFAULT_COUNT_SIZE = 20;
    public static final String LOGIN_USERNAME = "shen";
    public static final String LOGIN_PASSWORD = "1";

    @Autowired
    SpittleRepository spittleRepository;

    /**
     * 登录成功之后的页面
     * @return
     */
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login/t", method = RequestMethod.POST)
    public String login(Spitter spitter) {
        // AuthorizationData
        log.debug("登录信息[]",spitter.toString());
        if (LOGIN_USERNAME.equals(spitter.getUsername())
                && (LOGIN_PASSWORD.equals(spitter.getPassword()))) {
            return "index";
        } else {
            return "login";
        }


    }
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,Model model) {
        if (error != null) {
            model.addAttribute("msg", "username or password is error !");
        }
        if (logout != null) {
            model.addAttribute("msg", "exit success !");
        }
        return "login";
    }

    @RequestMapping(value = "spittles", method = RequestMethod.GET)
    public String spittlels(Model model) {
        // 将spittle添加到模型中
       // model.addAllAttributes(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
       model.addAttribute("spittleList", spittleRepository.findSpittles(MAX_VALUE, DEFAULT_COUNT_SIZE));
        // 返回视图名
        return "spittles";
    }


    /**
     * 展示不同数量的数据
     * @param max 最大值
     * @param count 数量
     * @param model
     * @return spitterList
     */
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String showSpittles(@RequestParam(value = "max",defaultValue = "MAX_VALUE",required = true) long max,
                               @RequestParam(value = "count",defaultValue = "DEFAULT_COUNT_SIZE",required = true) int count,
                               Model model) {
        List<Spitter> spittleList = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList", spittleList);
        return "spittles";
    }


    /**
     * 通过id查找
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "spittle/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") Long spittleId, Model model) {
        List<Spittle> spittleList = new ArrayList<>();
        spittleList.add(spittleRepository.findOne(spittleId));
        model.addAttribute("spittleList", spittleList);
        return "spittles";
    }

    /**
     * 打开注册页面
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegisterationFrom() {
        return "registerForm";
    }

    /**
     * 注册BO 带有校验
     * @param spitter
     * @param errors
     * @return @Validated
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute(value="spitter") Spitter spitter, Errors errors) {

        // 如果表单校验出错，则返回到注册页面
        if (errors.hasErrors()) {
            return "registerForm";
        }
        // 重定向到基本信息页
        return "redirect:/spittle/" + spitter.getUsername();
    }


    /**
     * 通过spitter的username查找
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "spittle/{username}", method = RequestMethod.GET)
    public String spittle(@PathVariable("username") String username, Model model) {
        List<Spitter> spittleList = new ArrayList<>();
        spittleList.add(spittleRepository.findByUsername(username));
        model.addAttribute("spittleList", spittleList);

        for (Spitter spitter : spittleList) {
            
        }
        for (int i = 0; i < spittleList.size(); i++) {
            
        }
        return "spittles";
    }

    @RequestMapping(value = "findAllSpitters", method = RequestMethod.GET)
    public List<Spitter> findAllSpitters() {
        return spittleRepository.findAllSpitters();
    }

}
