//controller for page after authorisation

package by.jd2.library.controller;

import by.jd2.library.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller

//redirect to page after authorisation
public class WelcomeController {
    @Autowired(required = true)
    private IPersonService personService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage(HttpServletRequest request, Principal principal){
        String userEmail = principal.getName();
        request.getSession().setAttribute("person", personService.getPersonByEmail(userEmail));
        return "welcome";
    }
}
