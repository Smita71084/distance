package com.dwp.distance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dwp.distance.dto.Coordinates;
import com.dwp.distance.dto.DistanceResponse;
import com.dwp.distance.service.DistanceService;

@RestController
public class DistanceController {

	 private static final Double LONDON_LATITUDE = 51.5074;
	 private static final Double LONDON_LONGITUDE = 0.1278;
	 private static final String LONDON = "LONDON";

	 @Autowired
	 private DistanceService distanceService;

	 /**
	  * This method just get the users withing 60 miles of london(TO DO :- Make dynamic by passing the coordinates, location and distance in Request params)
	  * @return DistanceResponse
	  */
	 @RequestMapping(method = RequestMethod.GET, value = "/get-users-within-sixty-miles-of-london")
	 public DistanceResponse getUsersWithin60MilesOfLondon() {
		  Coordinates londonCoordinates = new Coordinates(LONDON_LATITUDE,LONDON_LONGITUDE);
		  return distanceService.getUsersWithinDistanceOfLocation(LONDON, 60.0, londonCoordinates.getLatitude(), londonCoordinates.getLongitude());
	 }
}
