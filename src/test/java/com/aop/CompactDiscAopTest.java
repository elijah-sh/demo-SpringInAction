package com.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/30 16:01
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:aop/aop-track-config.xml"})     // 加载配置文件
public class CompactDiscAopTest {

    @Autowired
    private BlankDisc disc;
    @Test
    public void playTrack() {
        disc.playTrack(2);
    }
}