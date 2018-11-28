package com.bean.config.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:32
 * @Description: 根据条件选择注入的bean
 */
public interface Condition {

    /**
     *
     * @param ctxt
     * @param metadata  AnnotatedTypeMetadata则能够让我们检查带有@Bean注解的方
     *                      法上还有什么其他的注解
     * @return  返回true 创建带有@Conditional注解的bean
     * 如果matches()方法 返回false， 将不会创建这些bean。
     */
    boolean matches(ConditionContext ctxt, AnnotatedTypeMetadata metadata);
}
