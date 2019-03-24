package com.xzj.jpa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_clazz")
public class Clazz {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    
//    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "clazz")
    @OneToMany(mappedBy = "clazz")
    private Set<Student> stus = new HashSet<>();
    
    @Temporal(TemporalType.DATE)
    private Date    date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStus() {
		return stus;
	}

	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}