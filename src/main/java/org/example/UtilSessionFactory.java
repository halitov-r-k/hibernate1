package org.example;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UtilSessionFactory {

   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
       System.out.println("getSessionFactory method");
       Configuration configuration = null;
       try {
           configuration = new Configuration()
                   .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                   .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db")
                   .setProperty("hibernate.connection.username", "root")
                   .setProperty("hibernate.connection.password", "root")
                   .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
           System.out.println("configuration is created");
       } catch (HibernateException e) {
           e.printStackTrace();
       }
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       }
   }