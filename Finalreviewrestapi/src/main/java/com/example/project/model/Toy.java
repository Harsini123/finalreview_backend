package com.example.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Customer;
    private String dept;
    private String list;
    
	public Toy() {
		super();
	}
	public Toy(Long id, String customer, String dept, String list) {
		super();
		this.id = id;
		Customer = customer;
		this.dept = dept;
		this.list = list;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
}
		