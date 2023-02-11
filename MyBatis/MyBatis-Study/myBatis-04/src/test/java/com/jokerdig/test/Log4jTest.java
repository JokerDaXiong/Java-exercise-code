package com.jokerdig.test;

import com.jokerdig.mapper.UserMapper;
import com.jokerdig.pojo.User;
import com.jokerdig.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Joker大雄
 * @data 2022/4/28 - 14:08
 **/
public class Log4jTest {
    static Logger logger =Logger.getLogger(MapperTest.class);
    @Test
    public void log4j(){
        logger.info("info:进入了log4j");
        logger.debug("debug:进入了log4j");
        logger.error("error:进入了log4j");
    }
}
