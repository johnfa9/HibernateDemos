package com.ga.DemoHibernateRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class App 
{
    public static void main( String[] args )
    {
    	Laptop1 laptop = new Laptop1();
        laptop.setLid(101);
        laptop.setLname("Dell");
        
        Student1 s = new Student1();
        s.setName("Navin");
        s.setRollno(1);
        s.setMarks(50);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class).addAnnotatedClass(Laptop1.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session =  sf.openSession();
        
        session.beginTransaction();
        session.save(laptop);
        session.save(s);
        
        session.getTransaction().commit();
    }
}
