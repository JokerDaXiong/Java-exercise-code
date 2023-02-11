package com.jokerdig.test;

import com.jokerdig.pojo.Books;
import com.jokerdig.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Joker大雄
 * @data 2022/6/14 - 16:11
 **/
public class ssmTest {
    @Test
    public void queryTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        for (Books books:bookServiceImpl.queryAllBooks()){
            System.out.println(books);
        }

    }
}
