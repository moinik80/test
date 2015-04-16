//controller for page with list authors

package by.jd2.library.controller;

import by.jd2.library.pojos.Book;
import by.jd2.library.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired(required = true)
    private IBookService bookService;

//    redirect to page with list authors
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String authorsPage(ModelMap model) {
        fillModel(model);
        return "authors";
    }

//    write in model list authors
    private void fillModel(ModelMap model) {
        List<String> list = bookService.getAuthors();
        model.put("authors", list);
    }
}
