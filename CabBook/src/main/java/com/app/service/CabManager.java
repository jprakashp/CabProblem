package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.exceptions.CabNotFoundException;
import com.app.model.Cab;
import com.app.model.CabLocation;

@Service
public class CabManager {
	public Map<String, Cab> cabs = new HashMap<>();

	public boolean createCab(Cab newCab){
		if (cabs.containsKey(newCab.getCabId())) {
			return false;
		}else {
			cabs.put(newCab.getCabId(), newCab);
			return true;
		}
	}

	public Cab updateCabLocation(String cabId, CabLocation newLocation) {
		if (!cabs.containsKey(cabId)) {
			return null;
		}
		cabs.get(cabId).setCurrentLocation(newLocation);
		return cabs.get(cabId);
	}

	public Cab updateCabAvailability(String cabId, boolean newAvailability) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException("Cab Id not found");
		}
		cabs.get(cabId).setAvailable(newAvailability);
		return cabs.get(cabId);
	}

	public List<Cab> getCabs(CabLocation fromPoint, Double distance) {
		List<Cab> result = new ArrayList<>();
		for (Cab cab : cabs.values()) {
			if (cab.isAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
				result.add(cab);
			}
		}
		return result;
	}

	public Cab getCab(String cabId) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException("Cab Id not found");
		}
		return cabs.get(cabId);
	}
}
