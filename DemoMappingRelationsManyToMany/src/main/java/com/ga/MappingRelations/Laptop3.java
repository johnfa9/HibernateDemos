package com.ga.MappingRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop3 {
	@Id
	private int lid;
	private String lname;
	@ManyToMany  // w/o this laptop would not have student id
	private List<Student3> student= new ArrayList<Student3>();  
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<Student3> getStudent() {
		return student;
	}
	public void setStudent(List<Student3> student) {
		this.student = student;
	}
	
	
	
}
