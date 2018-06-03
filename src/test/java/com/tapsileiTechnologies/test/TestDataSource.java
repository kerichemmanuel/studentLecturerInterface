package com.tapsileiTechnologies.test;

import com.tapsileiTechnologies.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Vikram
 */
public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"Vikram", "9303580884", "vikram@ezeon.net", "Bhopal", "v", "v123"};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
    }
}