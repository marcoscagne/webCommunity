package controller;

import config.HibernateUtil;
import crud.CRUD;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("eventi", c.listEventi(false));
        map.put("commenti",c.listCommenti());
        return "index";
    }
    
    @RequestMapping(value = "/login")
    public String login(ModelMap map) {
        return "login";
    }
    
    @RequestMapping(value = "/eventi")
    public String eventi(ModelMap map) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("eventi", c.listEventi(true));
        map.put("commenti",c.listCommenti());
        map.put("pastEvents",c.pastEvents());
        return "eventi";
    }
    
    @RequestMapping(value = "/registrazione")
    public String registrazione(ModelMap map) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("categorie", c.listCategorie());
        return "registrazione";
    }
    
}
