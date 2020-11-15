package com.sotnikov.memstorage.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tags")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    
    @Column(name="Name")
    private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	

	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public Tag(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	public Tag() {	}
    
    
    
	
}
