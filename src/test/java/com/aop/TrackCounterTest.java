package com.aop;

import com.bean.soundsystem.CompactDisc;
import com.bean.soundsystem.TrackCounter;
import com.bean.soundsystem.config.SoundSystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/30 10:29
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)     // 加载配置文件
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter(){

        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);
        cd.playTrack(7);
        assertEquals(0, counter.getPlayCount(1) );
        assertEquals(1, counter.getPlayCount(2) );
        assertEquals(4, counter.getPlayCount(3) );
        assertEquals(0, counter.getPlayCount(4) );
    }

    @Autowired
    private Performance performance;

    @Test
    public void testPerformance(){
        performance.perform("shen","shuaihu");
    }













}
