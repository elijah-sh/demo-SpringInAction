package com.bean.soundsystem;


import com.bean.soundsystem.config.CDPlayerConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 10:54
 * @Description: 测试bean是否被创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)     // 加载配置文件
//@ContextConfiguration(locations = {"classpath*:/bean/soundsystem/cdplayer-config.xml"})
//@Slf4j
public class CDPlayerTest {

    //@Rule
 //  public final StandardOutputStreamLog log = new StandardOutputStreamLog();
 //    @Autowired
 //    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    // @Test
    // public void cdShouNotBeNull(){
    //     assertNotNull(cd);
    // }

    @Test
    public void play(){
        player.play();
       // assertEquals("Playing Sgt. Peppers`s Lonely Hearts Club Band . by The Beatles", );
    }

}
