package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CabBook;
import com.app.model.Rider;
import com.app.model.Trip;
import com.app.service.RidersManager;
import com.app.service.TripsManager;

@RestController
public class RidersController {
	@Autowired
	RidersManager ridersManager;
	@Autowired
	TripsManager tripsManager;

	@PostMapping(value = "/register/rider",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rider> registerRider(@RequestBody Rider rider) {
		ridersManager.createRider(rider);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/bookcab",
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CabBook> book(@RequestBody CabBook cabBook) {

		tripsManager.createTrip(ridersManager.getRider(cabBook.getRiderId()), cabBook.getSourceLoc(),
				cabBook.getDestLoc());

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/book/{riderid}",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trip>> fetchHistory(@PathVariable(value = "riderid") String riderId) {
		List<Trip> trips = tripsManager.tripHistory(ridersManager.getRider(riderId));
		return new ResponseEntity<>(trips, HttpStatus.OK);
	}

}
