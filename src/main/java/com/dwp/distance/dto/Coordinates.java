package com.dwp.distance.dto;

import java.util.Objects;

public class Coordinates {

	 private final double latitude;
	 private final double longitude;

	 public Coordinates(double latitude, double longitude) {
		  this.latitude = latitude;
		  this.longitude = longitude;
	 }

	 public double getLatitude() {
		  return latitude;
	 }

	 public double getLongitude() {
		  return longitude;
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (!(o instanceof Coordinates)) return false;
		  Coordinates that = (Coordinates) o;
		  return Double.compare(that.latitude, latitude) == 0 &&
				  Double.compare(that.longitude, longitude) == 0;
	 }

	 @Override
	 public int hashCode() {
		  return Objects.hash(latitude, longitude);
	 }

	 @Override
	 public String toString() {
		  return new StringBuilder()
				  .append("Coordinates [")
				  .append("latitude=")
				  .append(latitude)
				  .append(", ")
				  .append("longitude=")
				  .append(longitude).append(", ")
				  .append("]").toString();
	 }
}
