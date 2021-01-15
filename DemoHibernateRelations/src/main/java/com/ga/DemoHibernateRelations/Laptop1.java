package com.ga.DemoHibernateRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop1 {
	@Id
	private int lid;
	private String lname;
	
	@ManyToOne
	private Student1 stud;  //adds a stud_rollno  column in this table, when a @oOneToMany annotation is used in Student ,must include @ManyToOne in laptop to create column in laptop
	
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
	public Student1 getStud() {
		return stud;
	}
	public void setStud(Student1 stud) {
		this.stud = stud;
	}
	
	
}
