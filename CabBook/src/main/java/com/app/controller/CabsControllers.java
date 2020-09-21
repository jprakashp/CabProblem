package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.CabAlreadyExistsException;
import com.app.exceptions.CabNotFoundException;
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
		Cab updatedcab = cabManager.updateCabLocation(cabId, currentLocation);
		if(updatedcab != null) {
			return new ResponseEntity<Cab>(updatedcab, HttpStatus.OK);
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
		return new ResponseEntity<Cab>(updatedCab, HttpStatus.OK);
	}

	@PutMapping(path = "/endtrip/cab/{cabid}",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cab> endTrip(@PathVariable(value = "cabid") String cabId) {
		tripsManager.endTrip(cabManager.getCab(cabId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
