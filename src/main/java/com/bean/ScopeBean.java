package com.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 20:20
 * @Description:
 */
public class ScopeBean {

    /**
     * 购物车非常适合 SESSION 这个作用域
     * @return
     * 每个会话创建一个ShoppingCart。 这会创建多 个ShoppingCart bean的实例， 但是对于给定的会话只会创建一个
     * 实例， 在当前会话相关的操作中， 这个bean实际上相当于单例的。
     *  proxyMode = ScopedProxyMode.INTERFACES 解决了将会话或请求作用域的bean注入到单例bean中所遇到的问题
     */
    @Bean
  //  @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
    public ShoppingCat cart(){
       return new ShoppingCat();
    }
}

