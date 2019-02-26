package com.bean.config;

import com.bean.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 09:57
 * @Description:  注入外部的值
 */

@Configuration
@PropertySource("classpath:/bean/bean.properties")
public class ExpressiveConfig {

    @Autowired
    private Environment environment;

   /* @Bean
    public BlankDisc disc(){
        if (!environment.containsProperty("disc.title")){
            return null;
        }
        return new BlankDisc(
                environment.getProperty("disc.title") ,
                //  这样在指定属性不存  在的时候， 会使用一个默认值：
                environment.getProperty("disc.artist","jack.chou"),
                null);
    }*/
}
