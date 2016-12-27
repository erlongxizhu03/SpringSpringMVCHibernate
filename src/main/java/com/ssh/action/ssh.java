package com.ssh.action;

import com.ssh.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/27.
 */
@Controller
@RequestMapping("/ssh")
public class ssh {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/addDept")
    public void addDept() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Dept dept = new Dept(2, "222", "222");
            session.persist(dept);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
