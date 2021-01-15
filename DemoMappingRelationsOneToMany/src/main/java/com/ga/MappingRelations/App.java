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
    	Laptop2 laptop = new Laptop2();
        laptop.setLid(101);
        laptop.setLname("Dell");
        
        Student2 s = new Student2();
        s.setName("Navin");
        s.setRollno(1);
        s.setMarks(50);
        s.getLaptop().add(laptop);
        
        laptop.setStudent(s);  //populates the Rollno column
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student2.class).addAnnotatedClass(Laptop2.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session =  sf.openSession();
        
        session.beginTransaction();
        session.save(laptop);
        session.save(s);
        
        session.getTransaction().commit();
    }
}
