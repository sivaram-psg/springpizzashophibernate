package com.meena.pizzashop;
// imports..

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaDAO pizzaDAO;

    /**
     * This handler method is invoked when
     * http://localhost:8080/pizzashop is requested.
     * The method returns view name "index"
     * which will be resolved into /WEB-INF/index.jsp.
     *  See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Pizza> pizzas = pizzaDAO.findAll();
        model.addAttribute("pizzas", pizzas);
        return "index";
    }
}