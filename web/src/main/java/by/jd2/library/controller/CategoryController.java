//controller for page with list categories

package by.jd2.library.controller;

import by.jd2.library.pojos.Category;
import by.jd2.library.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

//    redirect to page with list categories
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String categoriesPage(ModelMap model) {
        fillModel(model);
        return "categories";
    }

//    write in model list categories
    private void fillModel(ModelMap model) {
        List<String> list = categoryService.getCategoriesName();
        model.put("categories", list);
    }
}
