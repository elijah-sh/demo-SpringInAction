package com.bean.soundsystem.config;

import com.bean.soundsystem.CDPlayer;
import com.bean.soundsystem.CompactDisc;
import com.bean.soundsystem.SgtPeppers;
import com.bean.soundsystem.WhileAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 10:48
 * @Description:  扫描配置
 *      @ComponentScan 默认扫描该包以内的 或者可以通过xml配置
 */
@Configuration
//@ComponentScan(basePackages = "com.bean.soundsystem")
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    /**
     * 随机播放甲壳虫乐队中的歌曲
     * @return
     */
    @Bean
    public CompactDisc randomBeatlesCd(){

        int choice = (int) Math.floor(Math.random() * 2);
        System.out.println("choice: "+choice);
        switch (choice){
            case 0 :
                return new SgtPeppers();
            case 1 :
                return new WhileAlbum();

            default:
                return new SgtPeppers();
        }
      //  return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(randomBeatlesCd());
    }

}

