package com.bean.config.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:47
 * @Description:
 */
public class ProfileCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        if (context.getEnvironment() != null){
            MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
            if (attrs != null){
                for (Object value : attrs.get("value")){
                    return true;
                }
            }
            return false;
        }

        return true;
    }
}
