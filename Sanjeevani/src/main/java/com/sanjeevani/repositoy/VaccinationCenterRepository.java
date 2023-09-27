package com.sanjeevani.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeevani.model.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}

