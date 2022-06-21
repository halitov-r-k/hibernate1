package org.example;

import org.example.UtilSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App
{

    public static void main( String[] args )
    {
        System.out.println( "method main()" );

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(session.isOpen());
        session.close();
        System.out.println(session.isOpen());
        HibernateUtil.shutdown();
    }

}
