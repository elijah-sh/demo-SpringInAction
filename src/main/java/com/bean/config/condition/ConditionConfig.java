package com.bean.config.condition;

import com.bean.MagicBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:54
 * @Description:
 */
@Configuration
public class ConditionConfig {

    /**
     * 条件化的创建bean
     * @return
     */
    @Bean
  //  @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
