package com.bean;

import com.bean.config.DataSourceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/28 16:12
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
@ActiveProfiles("dev")
public class PersistenceTest {
}
