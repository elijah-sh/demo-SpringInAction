package com.bean.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 15:33
 * @Description:
 */
//@Component
public class WhileAlbum implements CompactDisc {

    private String title = "WhileAlbum. Peppers`s Lonely Hearts Club Band .";
    private String artist = "The Beatles";  //      甲壳虫 合唱队
    @Override
    public void play() {
        System.out.println("Playing " + title + " by "+ artist);
    }
}
