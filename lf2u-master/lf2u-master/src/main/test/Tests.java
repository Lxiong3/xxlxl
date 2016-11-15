import com.newthread.framework.service.CustomersService;
import com.newthread.framework.service.CustomersServiceImpl;
import com.newthread.framework.util.DateFormatUtils;
import com.newthread.framework.util.StringUtil;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:Lei Xiong
 */
public class Tests {

    private CustomersService customersService = new CustomersServiceImpl();

    @Test
    public void test() {

        customersService.getOrder("1");
    }

    @Test
    public void testxx() {
        System.out.println(StringUtil.randomInteger());
    }


    @Test
    public void testDate() {

        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println(DateFormatUtils.time2String(null));

    }
}
