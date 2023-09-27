package com.sanjeevani.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String vaccineName;
	
	private String description;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	@JsonIgnore
	@OneToOne(mappedBy  ="vaccine", cascade =CascadeType.ALL )
	private VaccineCount vaccineCount;
	
	
	
	
	
}
