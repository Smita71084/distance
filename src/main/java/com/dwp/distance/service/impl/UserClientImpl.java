package com.dwp.distance.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dwp.distance.model.User;
import com.dwp.distance.service.UserClient;

@Service
public class UserClientImpl implements UserClient {

	 private static final Logger log = LoggerFactory.getLogger(UserClientImpl.class);

	 @Value("${user.baseUrl}")
	 private String baseUrl;

	 @Autowired
	 private RestTemplate restTemplate;

	 public UserClientImpl() {
	 }

	 @Override
	 public List<User> getAllUsers() {

		  log.debug("Getting Users");
		  ResponseEntity<User[]> response = restTemplate.getForEntity(baseUrl+"/users", User[].class);

		  List<User> users = parseResponse(response);

		  log.debug("[" + users.size() + "] Users returned");
		  return users;
	 }

	 @Override
	 public List<User> getAllUsersFromCity(String city) {

		  log.debug("Getting Users from City [" + city + "]");
		  ResponseEntity<User[]> response = restTemplate.getForEntity(baseUrl+"/city/"+city+"/users", User[].class);

		  List<User> users = parseResponse(response);

		  for (User u : users) {
				u.setCity(city);
		  }

		  log.debug("[" + users.size() + "] Users returned from City [" + city + "]");
		  return users;
	 }

	 @Override
	 public Optional<User> getUserById(int id) {

		  log.debug("Getting User with ID [" + id + "]");
		  ResponseEntity<User> response = restTemplate.getForEntity(baseUrl+"/user/"+ id, User.class);

		  return Optional.ofNullable(response.getBody());
	 }

	 private List<User> parseResponse(ResponseEntity<User[]> response) {
		  List<User> users = new ArrayList<>();

		  if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {
				users = Arrays.asList(response.getBody());
		  }
		  return users;
	 }
}
