package com.sanjeevani.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanjeevani.model.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

}
