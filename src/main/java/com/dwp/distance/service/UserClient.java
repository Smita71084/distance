package com.dwp.distance.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.dwp.distance.model.User;

public interface UserClient {

	 List<User> getAllUsers();

	 List<User> getAllUsersFromCity(String city);

	 Optional<User> getUserById(int id);
}
