package com.jokerdig.mapper;

import com.jokerdig.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/6/11 - 15:55
 **/
public interface BookMapper {
    // 增加书籍
    int addBook(Books books);
    // 删除书籍
    int deleteBook(@Param("bookId") int id);
    // 修改书籍
    int updateBook(Books books);
    // 查询单本书籍
    Books getBookById(@Param("bookId") int id);
    // 查询全部书籍
    List<Books> queryAllBooks();
    // 通过书名查询
    List<Books> queryBooksByName(@Param("bookName")String bookName);
}
