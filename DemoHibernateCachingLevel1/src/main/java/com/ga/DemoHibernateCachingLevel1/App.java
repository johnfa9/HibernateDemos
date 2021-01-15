package com.ga.DemoHibernateCachingLevel1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Collection;


public class App 
{
    public static void main( String[] args )
    {
      

        Alien5 a = null;
    	
        //configuration is a class
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien5.class);
        
        //SessionFactory is an interface, it is configuration of database
        
        //add following after removing deprecated method
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        //SessionFactory sf = con.buildSessionFactory();  //remove deprecated method
        
        //Session is an interface
        SessionFactory sf = con.buildSessionFactory(reg);  //replace deprecated method
        Session session1 =  sf.openSession();  //openSession returns object of session
        
       session1.beginTransaction();

       a = (Alien5) session1.get(Alien5.class, 103); //check first level and second level.  If not found create new query
       System.out.println(a);
       
       a = (Alien5) session1.get(Alien5.class, 103); //since first level cache same values, hibernate does not create another query
       System.out.println(a);
       
       a = (Alien5) session1.get(Alien5.class, 105); //since it has different values, hibernate creates a second query
       System.out.println(a);
       
       session1.getTransaction().commit();
       session1.close();
       
       
       Session session2 = sf.openSession();
       session2.beginTransaction(); 
       a = (Alien5) session2.get(Alien5.class, 103); //creates a new hibernate query since session1 was closed and level 2 caching not set up
       System.out.println(a);
       session2.getTransaction().commit();
       session2.close();
        
        
      
    }
}
