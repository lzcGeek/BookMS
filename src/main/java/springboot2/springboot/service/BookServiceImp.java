package springboot2.springboot.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import springboot2.springboot.SpringbootApplication;
import springboot2.springboot.dao.BookMapper;
import springboot2.springboot.pojo.Books;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringbootApplication.class)
public class BookServiceImp implements BookService {

    @Autowired(required = false)
    @Qualifier(value = "bookMapper")
    private BookMapper bookMapper;

//    @PostConstruct
//    public BookMapper setBookMapper() {
//        return bookMapper;
//    }



    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int bookID) {
        return bookMapper.deleteBookById(bookID);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int bookID) {
        return bookMapper.queryBookById(bookID);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> querBookByName(String bookName) { return bookMapper.querBookByName(bookName); }



}
