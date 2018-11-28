package com.bean.soundsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 10:06
 * @Description:
 */
@Configuration
@Import({CDConfig.class,CDPlayerConfig.class})
@ImportResource("classpath:bean/soundsystem/sound-config.xml")
public class SoundSystemConfig {
}
