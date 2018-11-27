package com.bean.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 13:57
 * @Description:
 *  CDPlayer的play方法使用CompactDisc中的play方法
 */
//@Component
public class CDPlayer implements MediaPlayer {

   // @Autowired
    private CompactDisc cd;

    @Autowired(required = false)
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

/*    @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }*/
    @Override
    public void play() {
        cd.play();
    }
}
