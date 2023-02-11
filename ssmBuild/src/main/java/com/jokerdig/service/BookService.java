package com.jokerdig.service;

import com.jokerdig.pojo.Books;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/6/11 - 16:12
 **/
public interface BookService {
    // 增加书籍
    int addBook(Books books);
    // 删除书籍
    int deleteBook(int id);
    // 修改书籍
    int updateBook(Books books);
    // 查询单本书籍
    Books getBookById(int id);
    // 查询全部书籍
    List<Books> queryAllBooks();
    // 书名查询书籍
    List<Books> queryBooksByName(String bookName);
}
