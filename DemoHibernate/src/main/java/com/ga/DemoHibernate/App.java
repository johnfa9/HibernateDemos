package com.ga.DemoHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien telusko=new Alien();
        telusko.setAid(106);
        telusko.setAname("mike");
        telusko.setColor("green");
       
        //configuration is a class
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        //SessionFactory is an interface, it is configuration of database
        
        //add following after removing deprecated method
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        //SessionFactory sf = con.buildSessionFactory();  //remove deprecated method
        
        //Session is an interface
        SessionFactory sf = con.buildSessionFactory(reg);  //replace deprecated method
        Session session =  sf.openSession();  //openSession returns object of session
        
        Transaction tx = session.beginTransaction();
        
        session.save(telusko);  //save belongs to session interface
        //tx.commit();
        
        //tx=session.beginTransaction();
        telusko = (Alien) session.get(Alien.class, 103);  //get method returns Object type
        tx.commit();
        		
        System.out.println(telusko);
    }
}
