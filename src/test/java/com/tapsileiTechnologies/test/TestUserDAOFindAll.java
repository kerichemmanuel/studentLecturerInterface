package com.tapsileiTechnologies.test;

import com.tapsileiTechnologies.config.SpringRootConfig;
import com.tapsileiTechnologies.dao.UserDAO;
import com.tapsileiTechnologies.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author Vikram
 */
public class TestUserDAOFindAll {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println(u.getUserId() + " " + u.getName() + " " + u.getRole());
            //TODO: access other columns
        }

    }
}
