//controller to start-page

package by.jd2.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

//    redirect to start-page
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/index/error", method = RequestMethod.GET)
    public String indexErrorPage(ModelMap model) {
        model.put("error", "Вы неправильно ввели данные для авторизации");
        return "index";
    }
}
