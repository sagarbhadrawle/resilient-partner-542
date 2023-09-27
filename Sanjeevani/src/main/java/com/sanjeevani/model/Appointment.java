package com.sanjeevani.model;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {
	
	 @Id
	 @GeneratedValue(strategy =  GenerationType.UUID)
	 private String bookingId;
	 
	 private String mobileNo;
	 
	 private LocalDate dateOfBooking;
	 
	 @Enumerated(EnumType.STRING)
	 private Slot slot;
	 
	 private boolean bookingStatus;
	 
	 @JsonIgnore
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="memberid")
	 private Member memberId;
	 
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="vaccineCenter_id" )
	private VaccinationCenter vaccineCenter;
	
	
}
