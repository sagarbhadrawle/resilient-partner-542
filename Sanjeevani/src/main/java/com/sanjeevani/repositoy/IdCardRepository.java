package com.sanjeevani.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeevani.model.IdCard;

public interface IdCardRepository extends JpaRepository<IdCard, String> {

	

}
