package com.bean.config.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:41
 * @Description:
 */
public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext ctxt, AnnotatedTypeMetadata metadata) {

        Environment env = ctxt.getEnvironment();
        // 检查magic属性
        return env.containsProperty("magic");
    }
}
