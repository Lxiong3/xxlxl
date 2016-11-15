import com.newthread.framework.util.MessageMaker;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author:Lei  Xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class UserTests {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void test() {
    }

}
