package com.ga.MappingRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student3 {
	@Id
	private int rollno;
	private String name;
	private int marks;
	@ManyToMany (mappedBy="student")//student is the name of the Student2 object in Laptop, tells Student to not create a table, Laptop will create the rollno in it's table. w/o this 4 tables are created
	private List <Laptop3> laptop=new ArrayList<>();  //creates new table without mappedby
	
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

	
	public List<Laptop3> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop3> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [roono=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
}
