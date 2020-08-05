package com.dwp.distance.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dwp.distance.model.User;

public class DistanceResponse {

	 private final List<String> errorMessages = new ArrayList<>();
	 private Set<User> users;

	 public List<String> getErrorMessages() {
		  return errorMessages;
	 }

	 public Set<User> getUsers() {
		  return users;
	 }

	 public void setUsers(Set<User> users) {
		  this.users = users;
	 }

	 @Override
	 public String toString() {
		  return new StringBuilder()
				  .append("DistanceResponse [")
				  .append("users")
				  .append(getUsers())
				  .append("]")
				  .toString();
	 }
}
