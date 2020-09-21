package com.app.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.model.Cab;
import com.app.model.CabLocation;
import com.app.model.Rider;
@Component
public class DefaultCabMatchingUtil implements CabMatchingUtil {

	@Override
	public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, CabLocation fromPoint, CabLocation toPoint) {
		if (candidateCabs.isEmpty()) {
			return null;
		}
		candidateCabs.sort((Cab c1, Cab c2) -> c1.getCabId().compareTo(c2.getCabId()));
		return candidateCabs.get(0);
	}
}
