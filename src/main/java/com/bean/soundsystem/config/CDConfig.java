package com.bean.soundsystem.config;

import com.bean.soundsystem.CompactDisc;
import com.bean.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 10:10
 * @Description:
 */
@Configuration
public class CDConfig {

    @Bean
    @Primary
    public CompactDisc compactDisc(){
        return new SgtPeppers() ;
    }
}
