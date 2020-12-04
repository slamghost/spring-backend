package com.slamghost.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.ManyToOne;

@Entity(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	/*protected Long owner_id;*/
	 
     @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)     
	 private Contact owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Contact getOwner() {
		return owner;
	}

	public void setOwner(Contact owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", description=" + description + ", owner=" + owner + "]";
	}
	 
	 
	
}	
