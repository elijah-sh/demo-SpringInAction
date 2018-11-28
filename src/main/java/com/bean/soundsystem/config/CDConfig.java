package com.bean.soundsystem.config;

import com.bean.soundsystem.CompactDisc;
import com.bean.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 10:10
 * @Description:
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers() ;
    }
}
