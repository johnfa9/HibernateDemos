package com.ga.DemoHibernateCachingLevel2;


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
      

        Alien6 a = null;
    	
        //configuration is a class
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien6.class);
        
        //SessionFactory is an interface, it is configuration of database
        
        //add following after removing deprecated method
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        //SessionFactory sf = con.buildSessionFactory();  //remove deprecated method
        
        //Session is an interface
        SessionFactory sf = con.buildSessionFactory(reg);  //replace deprecated method
        Session session1 =  sf.openSession();  //openSession returns object of session
        
       session1.beginTransaction();

       a = (Alien6) session1.get(Alien6.class, 103); //check first level and second level.  If not found create new query
       System.out.println(a);
       
       
       session1.getTransaction().commit();
       session1.close();
       
       
       Session session2 = sf.openSession();
       session2.beginTransaction(); 
       a = (Alien6) session2.get(Alien6.class, 103); //reuses session1 query since Hibernate.cfg.xml updated,dependencies and cache annotations were added
       System.out.println(a);
       session2.getTransaction().commit();
       session2.close();
        
        
      
    }
}
