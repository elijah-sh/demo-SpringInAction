package com.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 14:49
 * @Description:
 */
@Component
public class Performance {

    public void perform(String str1, String str2){
        //   throw new RuntimeException(str1+str2);
       System.out.println(str1 + " " + str2);
    }
    //
    // @Bean("woodstcok")
    // public Performance performance(){
    //    return new Performance();
    // }
}
