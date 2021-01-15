package com.ga.DemoJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//create a maven quickstart project
//pu is in the resources folder under the main folder in folder view

public class App 
{
    public static void main( String[] args )
    {
    	 Alien a = new Alien();
         a.setAid(107);
         a.setAname("Maria");
         a.setColor("Black");
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	em.persist(a);  //persist saves to database
    	em.getTransaction().commit();

    	//    	Alien a = em.find(Alien.class, 103);
    	//    	System.out.println(a);
    }
}
