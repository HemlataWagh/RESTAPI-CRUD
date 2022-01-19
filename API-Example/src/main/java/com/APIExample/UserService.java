package com.APIExample;

import java.util.List;

public interface UserService {
	userRegistration saveuserRegistration(userRegistration user);
	List<userRegistration> getAllusers();
	userRegistration getUserRegistrationById(Integer userId);
	userRegistration updateRegistration(userRegistration user, Integer userId);
	void deleteuserRegistration(Integer userId);
	
	}
