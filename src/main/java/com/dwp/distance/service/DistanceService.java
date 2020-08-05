package com.dwp.distance.service;

import com.dwp.distance.dto.DistanceResponse;

public interface DistanceService {

	 DistanceResponse getUsersWithinDistanceOfLocation(String locationName,
			 Double distance,
			 Double locationLatitude,
			 Double locationLongitude);
}
