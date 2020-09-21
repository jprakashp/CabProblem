package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.CabAlreadyExistsException;
import com.app.exceptions.CabNotFoundException;
import com.app.exceptions.TripNotFoundException;
import com.app.model.Cab;
import com.app.model.CabLocation;
import com.app.service.CabManager;
import com.app.service.TripsManager;

@RestController
public class CabsControllers {
	@Autowired
	CabManager cabManager;
	@Autowired
	TripsManager tripsManager;

	@PostMapping(path = "/register/cab", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cab> registerCab(@RequestBody Cab cab) {
		boolean flag = cabManager.createCab(cab);
		if(flag) {
			return new ResponseEntity<Cab>(HttpStatus.OK);
		}else {
			throw new CabAlreadyExistsException("Cab Id already available");
		}
	}

	@PutMapping(path = "/location/cab/{cabid}",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cab> locationUpdate(@PathVariable(value = "cabid") String cabId, @RequestBody CabLocation currentLocation) {
		Cab updatedCab = cabManager.updateCabLocation(cabId, currentLocation);
		if(updatedCab != null) {
			return new ResponseEntity<Cab>(updatedCab, HttpStatus.OK);
		}else {
			throw new CabNotFoundException("Cab Id not found");
		}
	}

	@PutMapping(path = "/availability/cab/{cabid}",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cab> updateCabAvailability(@PathVariable(value = "cabid") String cabId,
			@RequestBody Cab cab) {
		Cab updatedCab = cabManager.updateCabAvailability(cabId, cab.isAvailable());
		if(updatedCab != null) {
			return new ResponseEntity<Cab>(updatedCab, HttpStatus.OK);
		}else {
			throw new CabNotFoundException("Cab Id not found");
		}
	}

	@GetMapping(path = "/endtrip/cab/{cabid}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cab> endTrip(@PathVariable(value = "cabid") String cabId) {
		boolean flag = tripsManager.endTrip(cabManager.getCab(cabId));
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			throw new TripNotFoundException("no trip found");
		}
	}

}
