package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.exceptions.RiderAlreadyExistsException;
import com.app.exceptions.RiderNotFoundException;
import com.app.model.Rider;

@Service
public class RidersManager {
	Map<String, Rider> riders = new HashMap<>();
	
	public void createRider(Rider newRider) {
		if(riders.containsKey(newRider.getRiderId())){
			throw new RiderAlreadyExistsException("Rider Id is available");
		}
		riders.put(newRider.getRiderId(), newRider);
	}
	
	public Rider getRider(String riderId) {
	    if (!riders.containsKey(riderId)) {
	      throw new RiderNotFoundException("Rider id not found");
	    }
	    return riders.get(riderId);
	  }
	
}
