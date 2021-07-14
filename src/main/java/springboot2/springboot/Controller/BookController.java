package springboot2.springboot.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot2.springboot.dao.BookMapper;
import springboot2.springboot.pojo.Books;
import springboot2.springboot.service.BookService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

//    @Autowired(required = false)
//    @Qualifier(value = "bookService")//@Rousurce（name=”“）
//    @Resource
//    @Resource(name = "bookServiceImp")
    @Autowired
    private BookService bookService;



//    @PostConstruct
//    public void setBookService(BookService bookService) {
//        this.bookService = bookService;
//    }
    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "html/allBook";
    }

    @RequestMapping("/addBookPage")
    public String toAddPage(){
        return "html/addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books,Model model){
        int resutl = bookService.addBook(books);
        if (resutl==0){
            model.addAttribute("addMsg","Error!");
        }else{
            model.addAttribute("addMsg","successful!");
            return "redirect:/book/allBook";
        }
        return "html/addBook";
    }

    @RequestMapping("/UpdatePage")
    public String toUpdatePage(int bookID, Model model){
        System.out.println(""+bookID);
        Books books = bookService.queryBookById(bookID);
        model.addAttribute("Ubook",books);
        return "html/updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int bookID){
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        List<Books> books = bookService.querBookByName(queryBookName);
        if(books == null){
            books = bookService.queryAllBook();
        }
        model.addAttribute("list",books);
        return "html/allBook";
    }

    @RequestMapping("/verify")
    public String verifyAccount(String userName, String passWord, HttpSession session,Model model){
        if ("123".equals(userName) && "123".equals(passWord)) {
            session.setAttribute("user",userName);
            model.addAttribute("msg","Login Successful!");
            return "redirect:/book/allBook";
        }else {
            model.addAttribute("msg","UserName or PassAge error!");
            return "index";
        }

    }

}
