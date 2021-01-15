package com.ga.DemoHibernateCachingLevel2WithQuery;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class App 
{
    public static void main( String[] args )
    {
      

        Alien7 a = null;
    	
        //configuration is a class
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien7.class);
        
        //SessionFactory is an interface, it is configuration of database
        
        //add following after removing deprecated method
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        //SessionFactory sf = con.buildSessionFactory();  //remove deprecated method
        
        //Session is an interface
        SessionFactory sf = con.buildSessionFactory(reg);  //replace deprecated method
        Session session1 =  sf.openSession();  //openSession returns object of session
        
       session1.beginTransaction();
       //instead of using get method, use query
       Query q1 = session1.createQuery("from Alien7 where aid=103");  //don't need table name
       q1.setCacheable(true);
       a = (Alien7)q1.uniqueResult();
       System.out.println(a);
       
       
       session1.getTransaction().commit();
       session1.close();
       
       
       Session session2 = sf.openSession();
       session2.beginTransaction(); 
       Query q2 = session2.createQuery("from Alien7 where aid=103"); //will reuse session1 query, Alien7 is class not table
       q2.setCacheable(true);
       a = (Alien7)q2.uniqueResult();
       System.out.println(a);
       session2.getTransaction().commit();
       session2.close();
       
       Session session3 = sf.openSession();
       session3.beginTransaction();
       Query q3 = session3.createQuery("from Alien7");
       List<Alien7> aliens =q3.list();
       
       for(Alien7 s : aliens ) {
    	   System.out.println(s);
       }
       
       session3.getTransaction().commit();
       session3.close();
       
       Session session4 = sf.openSession();
       session4.beginTransaction();
       //need select if specifying columns
       Query q4 = session4.createQuery("select aname, color from Alien7 where aid=103");
       Object [] alien = (Object[]) q4.uniqueResult();
       
       for(Object s : alien ) {
    	   System.out.println(s);
       }
       
       session4.getTransaction().commit();
       session4.close(); 
       
       Session session5 = sf.openSession();
       session5.beginTransaction();
       //need select if specifying columns
       Query q5 = session5.createQuery("select aname, color from Alien7");
       List<Object []> alien2 = (List <Object[]>) q5.list();
       
       for(Object [] s : alien2 ) {
    	   System.out.println(s[0] + " : " + s[1]);
       }
       
       session5.getTransaction().commit();
       session5.close(); 
       
       //Using an SQL query in Hibernate
       //Native query
       Session session6 = sf.openSession();
       session6.beginTransaction();
       SQLQuery query = session6.createSQLQuery("select * from alien");  //use table name in database
       query.addEntity(Alien7.class);  //specifies what type of data you are getting and it is an entire row
       List <Alien7> alien3 = query.list();
       
       for(Alien7 s : alien3 ) {
    	   System.out.println(s);
       }
       
       session6.getTransaction().commit();
       session6.close(); 
       
       //Using an SQL query in Hibernate where you are not retrieving all the columns
       //Native query
       Session session7 = sf.openSession();
       session7.beginTransaction();
       SQLQuery queryCol = session7.createSQLQuery("select aname,color from alien");  //use table name in database
      //cannot use addEntity since you are receiving specific columns
       queryCol.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); //convert output into map format
       List alien4 = queryCol.list();
       
       for(Object s : alien4 ) {
    	   Map m = (Map)s;
    	   System.out.println(m.get("aname") + " : " + m.get("color"));
       }
       
       session7.getTransaction().commit();
       session7.close(); 
    }
}
