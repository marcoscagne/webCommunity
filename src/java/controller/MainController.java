package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        return "index";
    }
    
    @RequestMapping(value = "/login")
    public String login(ModelMap map) {
        return "login";
    }
    
    @RequestMapping(value = "/registrazione")
    public String registrazione(ModelMap map) {
        return "registrazione";
    }
    
}
