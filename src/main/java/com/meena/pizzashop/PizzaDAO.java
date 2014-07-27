package com.meena.pizzashop;
// imports..

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PizzaDAO {
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(PizzaDAO.class);
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    /*@PersistenceContext(name = "pizzaDAO")
    private EntityManager em;*/
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @Transactional
    public List<Pizza> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List pizzas = session.createQuery("from Pizza").list();
        return pizzas;
    }

   // @Transactional
    public void findItem(){
        logger.debug("logging test findItem called");
       EntityManager em = entityManagerFactory.createEntityManager();
      em.getTransaction().begin();
       Item item = new Item();
       item.setName("test");
        System.out.println("id before persist "+item.getId());
        em.persist(item);
        Item item1 = em.find(Item.class,4l);
        if(item1 != null){
            item1.setName("new name");
        }
       em.flush();
        em.getTransaction().commit();
      //  em.close();

    //
    //
    // = entityManagerFactory.createEntityManager();
    //    em.getTransaction().begin();
        Long item_id = item.getId();
       System.out.println("id after persist "+item_id);
   //    em.getTransaction().begin();

      //  em.merge(item1);
//       em.flush();
    //    em.getTransaction().commit();

        em.close();
}
}