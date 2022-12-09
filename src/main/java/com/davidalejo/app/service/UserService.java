package com.davidalejo.app.service;

import java.util.Optional;

import com.davidalejo.app.domain.User;

public interface UserService {

	Optional <User> findById(Integer id);
}
