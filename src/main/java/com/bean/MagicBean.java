package com.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:55
 * @Description:
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //  原型作用域
public class MagicBean {
}
