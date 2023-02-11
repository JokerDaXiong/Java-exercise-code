package com.jokerdig.controller;

import com.jokerdig.pojo.Books;
import com.jokerdig.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Joker大雄
 * @data 2022/6/14 - 15:41
 **/
@Controller
@RequestMapping("/book")
public class BookController {
    // 注入service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }
    // 跳转到添加书籍
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }
    // 添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    // 跳转修改书籍页面
    @RequestMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable("id") int id, Model model){
        Books book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }
    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    // 删除书籍
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }
    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBooksByName(queryBookName);
        model.addAttribute("list",books);
        return "allBook";
    }

}
