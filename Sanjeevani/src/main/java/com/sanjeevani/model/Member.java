package com.sanjeevani.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 
	 @Column(columnDefinition = "boolean default false")
	 private Boolean dose1Status;
	 
	 @Column(columnDefinition = "boolean default false")
	 private Boolean dose2Status;
	 
	 private LocalDate dose1Date;
	 
	 private LocalDate dose2Date;
	 
	 private String MobileNo;
	 
	 private LocalDate dateOfRegistration = LocalDate.now();
	 
	 @JsonIgnore
	 @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	 private User user;
	
	 @OneToOne(mappedBy = "memberId", cascade = CascadeType.ALL)
	 private Appointment appointment;
	 
	 @JsonIgnore
	 @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	 private Vaccine vaccine;
	 
	 
	 
}
