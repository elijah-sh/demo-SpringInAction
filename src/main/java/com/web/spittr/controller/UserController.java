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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: user操作
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-28 11:24
 */
@Controller
@RequestMapping("/spittle/user")
@Slf4j
public class UserController {
    public static final Long MAX_VALUE = Long.MAX_VALUE;
    public static final int DEFAULT_COUNT_SIZE = 20;
    public static final String LOGIN_USERNAME = "shen";
    public static final String LOGIN_PASSWORD = "1";

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

}
