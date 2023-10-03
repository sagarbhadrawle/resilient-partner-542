package com.sanjeevani.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sanjeevani.exception.VaccineNotFoundException;
import com.sanjeevani.model.VaccinationCenter;
import com.sanjeevani.repositoy.VaccinationCenterRepository;
import com.sanjeevani.service.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImp implements VaccinationCenterService {


	private VaccinationCenterRepository vaccinationCenterRepository;

	@Autowired
	public VaccinationCenterServiceImp(VaccinationCenterRepository vaccinationCenterRepository) {
		super();
		this.vaccinationCenterRepository = vaccinationCenterRepository;
	}


	@Override
	public List<VaccinationCenter> getAllVaccinationCenter(Pageable pageable) {
		
		Page<VaccinationCenter> list = vaccinationCenterRepository.findAll(pageable);
		if (list == null)
			throw new VaccineNotFoundException("not any Vaccination Center"); // Connection for Exception here
		return list.toList();
	}


	@Override
	public VaccinationCenter getVaccination(Integer centerId) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		Optional<VaccinationCenter> optional = vaccinationCenterRepository.findById(centerId);
		if (optional.isEmpty())
			throw new VaccineNotFoundException("Vaccination Center Not Found By Given Id");
		return optional.get();
	}


	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) {
		if (center == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Details");
		return vaccinationCenterRepository.save(center);
	}

	
	@Override
	public VaccinationCenter updateVaccineCenter(Integer centerId, VaccinationCenter center) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		if (center == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center");
		center.setCenterId(centerId);
		return vaccinationCenterRepository.save(center);
	}

	
	@Override
	public Boolean deleteVaccinationCenter(Integer centerId) {
		if (centerId == null)
			throw new VaccineNotFoundException("Please Provide Vaccination Center Id");
		vaccinationCenterRepository.deleteById(centerId);
		return true;
	}

}
