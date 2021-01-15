package com.ga.MappingRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student2 {
	@Id
	private int rollno;
	private String name;
	private int marks;
	@OneToOne
	private Laptop2 laptop;  //creates lid column in student table
	
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
	public Laptop2 getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop2 laptop) {
		this.laptop = laptop;
	}
	
	@Override
	public String toString() {
		return "Student [roono=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
}
