
package com.sanjeevani.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sanjeevani.model.Vaccine;

public interface VaccineService {
	
	public List<Vaccine> getAllVaccine(Pageable pageable);
	
	
	public Vaccine getVaccineByName(String vaccineName);
	
	public Vaccine getVaccineById(Integer vaccineId);
	
	public Vaccine addVaccine(Vaccine vaccine, Integer memberId);
	
	public Vaccine updateVaccine(Integer vaccineId, Vaccine vaccine);
	
	public String deleteVaccine(Integer vaccineId);
}
