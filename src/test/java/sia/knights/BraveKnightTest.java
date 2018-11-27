package sia.knights;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/26 15:54
 * @Description:
 */
 public class BraveKnightTest {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("chapter_01/bean.xml");
    @Test
    public void embarkOnQuest() {
        // 创建 Quest
        Quest mockQuest = new Quest( ) {
            @Override
            public void embark() {
                System.out.println("......");
            }
        };
        // 注入 Quest
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
       // verify(mockQuest).embark();
    }


}














