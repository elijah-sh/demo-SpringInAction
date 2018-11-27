package com.bean.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 10:37
 * @Description:  专辑
 */
//@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {

    // 佩珀斯中士的孤独之心团乐队。
    private String title = "Sgt. Peppers`s Lonely Hearts Club Band .";
    private String artist = "The Beatles";  //      甲壳虫 合唱队
    @Override
    public void play() {
        System.out.println("Playing " + title + " by "+ artist);
    }
}
