package com.ga.MappingRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop2 {
	@Id
	private int lid;
	private String lname;
	@ManyToOne  // w/o this laptop would not have student id
	private Student2 student;  // w/o this laptop would not have student id in laptop table
	
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
	public Student2 getStudent() {
		return student;
	}
	public void setStudent(Student2 student) {
		this.student = student;
	}
	
	
}
