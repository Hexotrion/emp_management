package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="d_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer d_id;
    private String d_Name;
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getD_Name() {
		return d_Name;
	}
	public void setD_Name(String d_Name) {
		this.d_Name = d_Name;
	}
	public Department(Integer d_id, String d_Name) {
		super();
		this.d_id = d_id;
		this.d_Name = d_Name;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", d_Name=" + d_Name + "]";
	}

 
}
