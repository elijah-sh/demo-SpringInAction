package com.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 19:41
 * @Description:
 */
@Component
@Qualifier("cold")   // 预选
public class IceCream implements Dessert  {

    @Bean
    @Primary
    public Dessert iceCream(){
        return new IceCream();
    }


}
