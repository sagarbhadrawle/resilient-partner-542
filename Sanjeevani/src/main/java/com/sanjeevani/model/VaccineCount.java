package com.sanjeevani.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class VaccineCount {
			
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer vaccineCountId;
	    private Integer vaccineQuantity;
	    private double vaccinePrice;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    private Vaccine vaccine;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="vaccineInventory_Id")
	    private VaccineInventory vaccineInventory;
	    
	
}	
