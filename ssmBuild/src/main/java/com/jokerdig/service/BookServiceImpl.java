package com.jokerdig.service;

import com.jokerdig.mapper.BookMapper;
import com.jokerdig.pojo.Books;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/6/11 - 16:13
 **/
public class BookServiceImpl implements BookService {

    // mapper set注入
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public List<Books> queryBooksByName(String bookName) {
        return bookMapper.queryBooksByName(bookName);
    }
}
