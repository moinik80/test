//controller for page with list books

package by.jd2.library.controller;

import by.jd2.library.pojos.Book;
import by.jd2.library.pojos.Category;
import by.jd2.library.services.IBookService;
import by.jd2.library.services.ICategoryService;
import by.jd2.library.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired(required = true)
    private IBookService bookService;

    @Autowired(required = true)
    private ICategoryService categoryService;



//    redirect to page with list books
    @RequestMapping(value = "/books/{sortRow}/{sortFlag}", method = {RequestMethod.POST, RequestMethod.GET})
    public String booksPage(@PathVariable String sortRow,
                            @PathVariable String sortFlag,
                            @RequestParam(defaultValue = "5") String countResult,
                            @RequestParam(defaultValue = "") String navBtn,
                            @RequestParam(defaultValue = "1") String pageNumber,
                            ModelMap model) {

        if (!"".equals(navBtn)) {
            sortFlag = ("up".equals(sortFlag))?"down":"up";
            sortRow = ("books".equals(sortRow))?"authors":"books";
        }

        pageNumber = bookService.getPageNumber(pageNumber, countResult, navBtn)[0];
        String countPages = bookService.getPageNumber(pageNumber, countResult, navBtn)[1];


        fillModel(model, sortRow, sortFlag, countResult, pageNumber);

//        request parameters for sorts
        sortFlag = ("up".equals(sortFlag))?"down":"up";
        sortRow = ("books".equals(sortRow))?"authors":"books";

//        send some parameters in page
        model.put("countResult", countResult);
        model.put("pageNumber", pageNumber);
        model.put("countPages", countPages);
        model.put("sortFlag", sortFlag);
        model.put("sortRow", sortRow);

//      select links for sorts
        if ("authors".equals(sortRow)) {
            model.put("linkBooks", "/books/books/" + sortFlag + ".form");
            model.put("linkAuthors", "/books/authors/up.form");
        } else {
            model.put("linkBooks", "/books/books/up.form");
            model.put("linkAuthors", "/books/authors/" + sortFlag + ".form");
        }
        return "books";
    }

//    redirect to form "add book"
    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String addBookPage(ModelMap model) {
        List<Category> categories = categoryService.getCategories();
        model.put("categories", categories);
        return "addBook";
    }

    //    return book
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String bookPage(ModelMap model, @PathVariable String bookId) {
        int id = Integer.parseInt(bookId);
        Book book = (Book) bookService.get(id);
        model.put("book", book);
        return "book";
    }


//    redirect to page edit book
    @RequestMapping(value = "books/edit/{bookId}", method = RequestMethod.GET)
    public String editBookPage(@PathVariable String bookId, ModelMap model) {
        model.put("bookId", bookId);
        return "editBook";
    }

    //    redirect to page delete book
    @RequestMapping(value = "books/del/{bookId}", method = RequestMethod.GET)
    public String delBookPage(@PathVariable String bookId, ModelMap model) {
        model.put("bookId", bookId);
        return "delBook";
    }

    // write in model list books with pagination
    private void fillModel(ModelMap model, String sortRow, String sortFlag, String countResult, String pageNumber) {
        List<Book> list = bookService.getBooks(sortRow, sortFlag, countResult, pageNumber);
        model.put("books", list);
    }
}
