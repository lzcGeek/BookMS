package springboot2.springboot.service;



import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import springboot2.springboot.pojo.Books;

import java.util.List;

public interface BookService {
    //add a book
    int addBook(Books books);
    //delete a book
    int deleteBookById(int bookID);
    //update
    int updateBook(Books books);
    //query
    Books queryBookById(int bookID);
    //query all
    List<Books> queryAllBook();

    List<Books> querBookByName(String bookName);
}
