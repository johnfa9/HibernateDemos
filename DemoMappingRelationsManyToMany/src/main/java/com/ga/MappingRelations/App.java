package com.ga.MappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    	Laptop3 laptop = new Laptop3();
        laptop.setLid(101);
        laptop.setLname("Dell");
        
        Student3 s = new Student3();
        s.setName("Navin");
        s.setRollno(1);
        s.setMarks(50);
        s.getLaptop().add(laptop);
        
        laptop.getStudent().add(s);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student3.class).addAnnotatedClass(Laptop3.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session =  sf.openSession();
        
        session.beginTransaction();
        session.save(laptop);
        session.save(s);
        
        session.getTransaction().commit();
    }
}
