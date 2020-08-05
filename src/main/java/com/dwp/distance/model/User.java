package com.dwp.distance.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	 //Json properties
	 private int id;
	 @JsonProperty("first_name")
	 private String firstName;
	 @JsonProperty("last_name")
	 private String lastName;
	 private String email;
	 @JsonProperty("ip_address")
	 private String ipAddress;
	 private double latitude;
	 private double longitude;
	 private String city;
	 private double distance;

	 public int getId() {
		  return id;
	 }

	 public void setId(int id) {
		  this.id = id;
	 }

	 public String getFirstName() {
		  return firstName;
	 }

	 public void setFirstName(String firstName) {
		  this.firstName = firstName;
	 }

	 public String getLastName() {
		  return lastName;
	 }

	 public void setLastName(String lastName) {
		  this.lastName = lastName;
	 }

	 public String getEmail() {
		  return email;
	 }

	 public void setEmail(String email) {
		  this.email = email;
	 }

	 public String getIpAddress() {
		  return ipAddress;
	 }

	 public void setIpAddress(String ipAddress) {
		  this.ipAddress = ipAddress;
	 }

	 public double getLatitude() {
		  return latitude;
	 }

	 public void setLatitude(double latitude) {
		  this.latitude = latitude;
	 }

	 public double getLongitude() {
		  return longitude;
	 }

	 public void setLongitude(double longitude) {
		  this.longitude = longitude;
	 }

	 public String getCity() {
		  return city;
	 }

	 public void setCity(String city) {
		  this.city = city;
	 }

	 public double getDistance() {
		  return distance;
	 }

	 public void setDistance(double distance) {
		  this.distance = distance;
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (!(o instanceof User)) return false;
		  User user = (User) o;
		  return id == user.id &&
				  Objects.equals(firstName, user.firstName) &&
				  Objects.equals(lastName, user.lastName);
	 }

	 @Override
	 public int hashCode() {
		  return Objects.hash(id, firstName, lastName);
	 }

	 @Override
	 public String toString() {
		  return new StringBuilder()
				  .append("User [")
				  .append("id")
				  .append(getId())
				  .append(", ")
				  .append("firstName")
				  .append(getFirstName())
				  .append(", ")
				  .append("lastName")
				  .append(getLastName())
				  .append(", ")
				  .append("email")
				  .append(getEmail())
				  .append(", ")
				  .append("ipAddress")
				  .append(getIpAddress())
				  .append(", ")
				  .append("latitude")
				  .append(getLatitude())
				  .append(", ")
				  .append("longitude")
				  .append(getLongitude())
				  .append("]")
				  .toString();
	 }
}
