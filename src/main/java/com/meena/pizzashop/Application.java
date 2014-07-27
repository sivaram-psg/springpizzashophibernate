package com.meena.pizzashop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by meena on 20/7/14.
 */
public class Application {
    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("/webapp/WEB-INF/servlet-context.xml");
       PizzaDAO pizzaDAO =  (PizzaDAO)context.getBean("pizzaDAO");
       // pizzaDAO.findAll();
        pizzaDAO.findItem();


    }

}
