package springboot2.springboot.dao;



import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springboot2.springboot.pojo.Books;

import java.util.List;

@Component
public interface BookMapper {

    //add a book
    @Insert("insert into bookproject.books (bookName,bookCounts,detail) values (#{bookName},#{bookCounts},#{detail})")
    int addBook(Books books);
    //delete a book
    @Delete("delete from bookproject.books where bookID = #{bookID}")
    int deleteBookById(@Param("bookID") int id);
    //update
    @Update("update bookproject.books set bookName=#{bookName},bookCounts=#{bookCounts},detail=#{detail} where bookID=#{bookID}")
    int updateBook(Books books);
    //query
    @Select("select * from bookproject.books where bookID=#{bookID}")
    Books queryBookById(@Param("bookID") int id);
    //query all
    @Select("select * from bookproject.books")
    List<Books> queryAllBook();

    @Select("select * from bookproject.books where bookName like CONCAT(CONCAT('%',#{bookName}),'%')")
    List<Books> querBookByName(@Param("bookName") String bookName);

}
