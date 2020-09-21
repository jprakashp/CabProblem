package com.app.utils;


import java.util.List;

import com.app.model.Cab;
import com.app.model.CabLocation;
import com.app.model.Rider;

public interface CabMatchingUtil {

  Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, CabLocation fromPoint, CabLocation toPoint);
}
