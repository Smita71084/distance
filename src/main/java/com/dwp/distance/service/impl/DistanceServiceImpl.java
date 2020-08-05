package com.dwp.distance.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwp.distance.dto.Coordinates;
import com.dwp.distance.dto.DistanceResponse;
import com.dwp.distance.model.User;
import com.dwp.distance.service.DistanceService;
import com.dwp.distance.service.UserClient;
import com.dwp.distance.service.utils.DistanceUtils;

@Service("DistanceService")
public class DistanceServiceImpl implements DistanceService {

	 private final Logger log = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 private UserClient userClient;


	 @Override
	 public DistanceResponse getUsersWithinDistanceOfLocation(String locationName, Double distance, Double locationLatitude, Double locationLongitude) {
		  DistanceResponse results = new DistanceResponse();
		  Set<User> users = new HashSet<>();

		  if (!(locationName == null) && !locationName.isEmpty()) {
				users.addAll(userClient.getAllUsersFromCity(locationName));
		  } else {
				log.debug("No location name provided");
		  }

		  if (distance != null && locationLatitude != null && locationLongitude != null) {
				log.debug("Getting users within [{}] miles of [{} , {}]", distance, locationLatitude, locationLongitude);
				Coordinates coords = new Coordinates(locationLatitude, locationLongitude);
				users.addAll(getUsersWithinRangeOfCoords(distance, coords));
		  }
		  else {
				log.debug("No coordinates provided");
		  }

		  log.debug("[{}] users found", users.size());
		  results.setUsers(users);

		  return results;

	 }

	 private List<User> getUsersWithinRangeOfCoords(double distance, Coordinates locationCoordinates) {

		  List<User> usersWithinRange = new ArrayList<>();

		  Collection<User> allUsers = userClient.getAllUsers();

		  for (User user : allUsers) {

				Coordinates userCoordinates = new Coordinates(user.getLatitude(), user.getLongitude());
				double distanceFromCoords = DistanceUtils.haversineDistance(userCoordinates, locationCoordinates);

				if (distanceFromCoords <= distance) {
					 user.setDistance(distanceFromCoords);
					 usersWithinRange.add(user);
				}
		  }

		  log.debug("[{}] users found within range", usersWithinRange.size());
		  return usersWithinRange;
	 }
}
