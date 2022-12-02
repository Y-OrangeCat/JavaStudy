package com.yang.controller;

import com.yang.pojo.Books;
import com.yang.service.BookService;
import com.yang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍
    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("list", booksList);
        return "allBook";
    }

    //跳转到增加书籍页面 addBook
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books, Model model) {
        bookService.addBook(books);
        System.out.println("addBook=>" + books);
        return "redirect:/book/allBook";
    }

    //跳转到修改书籍页面 updateBook
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model) {
        Books books = bookService.queryBook(id);
        System.out.println("toUpdateBook=> " + books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    //修改书籍请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books, Model model) {
        bookService.updateBook(books);
        System.out.println("updateBook=> " + books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBook(id);
//        System.out.println("delete=>");
        return "redirect:/book/allBook";
    }

    //根据书名查询书籍
    @RequestMapping("/queryBookByName")
    public String queryBookByName(String bookName,Model model) {
        System.out.println("queryBookByName=>" + bookName);
        Books books = bookService.queryBookByName(bookName);
        List<Books> list=new ArrayList<>();
        list.add(books);

        if(books==null){
            list= bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
