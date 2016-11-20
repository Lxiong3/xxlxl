package com.newthread.test;

import com.newthread.Data;
import com.newthread.domain.DeliversTo;
import com.newthread.exception.ArgumentsException;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.exception._404Exception;
import com.newthread.util.DateFormatUtils;
import com.newthread.util.MessageMaker;
import com.newthread.util.SerializeUtil;
import com.newthread.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class UtilTest {

    private final Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

    @Test
    public void test() {
        logger.info(StringUtil.getMD5("CC"));
        Assert.assertNull(Data.getData());

    }

    @Test
    public void tesDt() {
        logger.info(StringUtil.getDate() + "");
    }

    @Test
    public void dddd() {
        logger.info(StringUtil.obj2json("ddd") + "");
    }

    @Test
    public void tessddssDt() {
        logger.info(StringUtil.randomInteger() + "");
    }

    @Test
    public void tessssssDt() {
        logger.info(StringUtil.randomBoolean() + "");
    }

    @Test
    public void tessssDt() {
        logger.info(StringUtil.randomString() + "");
        Data.delivery_charge = 11.2;
    }


    @Test
    public void sssstesDt() {
        logger.info(StringUtil.isEmpty("") + "");
    }

    @Test
    public void tesDssst() {
        logger.info(StringUtil.isNumber("234") + "");
    }


    @Test
    public void tessssssssDt() {
        logger.info(DateFormatUtils.date2String(Calendar.getInstance().getTime()) + "");
    }


    @Test
    public void xxxtesDt() {
        String str = "ddddddddddddd";

        logger.info(SerializeUtil.serialize(str) + "");
    }

    @Test
    public void xxxtxesDt() {
        logger.info(MessageMaker.makeFid("dddd") + "");
    }

    @Test
    public void xxxtxexxxsDt() {
        logger.info(MessageMaker.makeFspid("dddd") + "");
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
