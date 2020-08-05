package com.dwp.distance.service.utils;

import com.dwp.distance.dto.Coordinates;

/**
 * Based on the formula and maths mentioned in the  https://rosettacode.org/wiki/Haversine_formula
 */
public final class DistanceUtils {

	 /** Radius of the average circumference */
	 private static final double AVG_RADIUS_CIRCUMFERENCE = 6372.8; // In kilometers

	 private static final double KM_TO_MILE_CONVERTER = 0.621371;

	 private DistanceUtils() {

	 }

	 /**
	  * Haversine formula to calculate the great-circle distance between two geo-coordinates
	  *
	  * @param sourceLat the latitude of the city ( London )
	  * @param sourceLon the Longitude of the oity ( London )
	  * @param destinationLat the destination Latitude.
	  * @param destinationLon the destination Longitude.
	  * @return the distance in miles.
	  */
	 public static double haversineDistance(final Coordinates sourceCoordinates,
			 final Coordinates destinationCoordinates) {
		  double differenceLat = Math.toRadians(destinationCoordinates.getLatitude() - sourceCoordinates.getLatitude());
		  double differenceLng = Math.toRadians(destinationCoordinates.getLongitude() - sourceCoordinates.getLongitude());
		  double sourceLatInRadians = Math.toRadians(sourceCoordinates.getLatitude());
		  double destinationLatInRadians = Math.toRadians(destinationCoordinates.getLatitude());

		  double a = Math.pow(Math.sin(differenceLat / 2),2) + Math.pow(Math.sin(differenceLng / 2),2) * Math.cos(sourceLatInRadians) * Math.cos(destinationLatInRadians);
		  double c = 2 * Math.asin(Math.sqrt(a));
		  return AVG_RADIUS_CIRCUMFERENCE * c * KM_TO_MILE_CONVERTER;
	 }

}