package com.sanjeevani.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeevani.model.VaccineInventory;
import com.sanjeevani.service.VaccineInventoryService;

@RestController
@CrossOrigin("*")
public class VaccineInventoryController {

	@Autowired
	private VaccineInventoryService vaccineInventoryService;

	/**
	 * This maps a GET request to the /vaccineinventories endpoint.
	 * ResponseEntity<List<VaccineInventory>>: This specifies the response type as a
	 * list of VaccineInventory objects. The method returns a list of all vaccine
	 * inventory items.
	 */
	@GetMapping(value = "/vaccineinventories/{pageNumber}/{pageSize}")
	public ResponseEntity<List<VaccineInventory>> getAllVaccineInventory(@PathVariable int pageNumber, @PathVariable int pageSize) {
		Pageable pageRequest = PageRequest.of(pageNumber-1, pageSize);
		return new ResponseEntity<List<VaccineInventory>>(vaccineInventoryService.getAllVaccineInventory(pageRequest),
				HttpStatus.ACCEPTED);
	}

	
	@GetMapping(value = "/vaccineinventories/bycenter/{centerId}")
	public ResponseEntity<VaccineInventory> getVaccinationInventoryByCenter(@PathVariable Integer centerId) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.getVaccinationInventoryByCenter(centerId),
				HttpStatus.ACCEPTED);
	}

		@PostMapping(value = "/vaccineinventories/{vaxCenterId}")
	public ResponseEntity<VaccineInventory> addVaccineCount(@PathVariable Integer vaxCenterId,
			@RequestBody VaccineInventory inv) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.addVaccineCount(vaxCenterId, inv),
				HttpStatus.ACCEPTED);
	}

	
	@PutMapping(value = "/vaccineinventories/{vaccineInvenId}")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@PathVariable Integer vaccineInvenId,
			@RequestBody VaccineInventory inv) {
		return new ResponseEntity<VaccineInventory>(vaccineInventoryService.updateVaccineInventory(vaccineInvenId, inv),
				HttpStatus.ACCEPTED);

	}

	
	@DeleteMapping(value = "/vaccineinventories/{vaccineInvenId}")
	public ResponseEntity<Boolean> deleteVaccinationInventory(@PathVariable Integer vaccineInvenId) {
		return new ResponseEntity<Boolean>(vaccineInventoryService.deleteVaccinationInventory(vaccineInvenId),
				HttpStatus.ACCEPTED);

	}

	
	@GetMapping(value = "/vaccineinventories/date/{date}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDate(@PathVariable LocalDate date) {
		return new ResponseEntity<List<VaccineInventory>>(vaccineInventoryService.getVaccineInventoryByDate(date),
				HttpStatus.ACCEPTED);
	}

		@GetMapping(value = "/vaccineinventories/id/{vaccineId}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByVaccine(@PathVariable Integer vaccineId) {
		return new ResponseEntity<List<VaccineInventory>>(
				vaccineInventoryService.getVaccineInventoryByVaccine(vaccineId), HttpStatus.ACCEPTED);
	}

}
