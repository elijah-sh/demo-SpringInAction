package com.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/30 15:18
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:aop/aop-config.xml"})     // 加载配置文件
public class PerformanceTest {

    @Autowired
    private Performance performance;
    @Test
    public void perform() {
        performance.perform("XXX","perform start");
    }
}
