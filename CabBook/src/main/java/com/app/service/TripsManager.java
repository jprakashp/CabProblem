package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.NoCabsAvailableException;
import com.app.exceptions.TripNotFoundException;
import com.app.model.Cab;
import com.app.model.CabLocation;
import com.app.model.Rider;
import com.app.model.Trip;
import com.app.utils.CabMatchingUtil;
@Service
public class TripsManager {
	public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
	private Map<String, List<Trip>> trips = new HashMap<>();
	@Autowired
	private CabManager cabsManager;
	@Autowired
	private CabMatchingUtil cabMatchingUtil;

	public void createTrip(Rider rider, CabLocation fromPoint, CabLocation toPoint) {

		List<Cab> closeByCabs = cabsManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
		List<Cab> closeByAvailableCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip() == null)
				.collect(Collectors.toList());
		Cab selectedCab = cabMatchingUtil.matchCabToRider(rider, closeByAvailableCabs, fromPoint, toPoint);
		if (selectedCab == null) {
			throw new NoCabsAvailableException("No cab id found");
		}

		Trip newTrip = new Trip(rider, selectedCab, fromPoint, toPoint);
		if (!trips.containsKey(rider.getRiderId())) {
			trips.put(rider.getRiderId(), new ArrayList<>());
		}
		trips.get(rider.getRiderId()).add(newTrip);
		selectedCab.setCurrentTrip(newTrip);
	}

	public List<Trip> tripHistory(Rider rider) {
		return trips.get(rider.getRiderId());
	}

	public boolean endTrip(Cab cab) {
		if (cab.getCurrentTrip() == null) {
			return false;
		}else {
			cab.getCurrentTrip().endTrip();
			cab.setCurrentTrip(null);
			return true;
		}
	}

}
