package com.ga.DemoHibernateRelations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student1 {
	@Id
	private int rollno;
	private String name;
	private int marks;
//	@OneToOne  //will add laptop_lid as foreign key in student1 table when laptop has no annotations
//	private Laptop1 laptop;
	
	@OneToMany (mappedBy = "stud")//will create a new table called student1_laptop1 with a student id and laptop id when laptop has no annotations
								  //mappedBy prevents Student from creating a separate table	
	private List<Laptop1> laptops;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;

	}
//	public Laptop1 getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop1 laptop) {
//		this.laptop = laptop;
//	}
	public List<Laptop1> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop1> laptops) {
		this.laptops = laptops;
	}
	
	
	
	
}
