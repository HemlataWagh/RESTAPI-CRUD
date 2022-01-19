package com.APIExample;

import java.util.List;
import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public userRegistration saveuserRegistration(userRegistration user) {
	
		return userRepository.save(user);
	}

	@Override
	public List<userRegistration> getAllusers() {
		return userRepository.findAll() ;
	}

	@Override
	public userRegistration getUserRegistrationById(Integer userId) {
//		Optional<userRegistration> user = userRepository.findById(userId);
//		if(user.isPresent()) {
//			return user.get();
//		}
//		else {
//			throw new ResourceNotFoundException("userRegistration", "userId", userId);
//		}
//		
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userRegistration", "userId", userId));
		
	}

	@Override
	public userRegistration updateRegistration(userRegistration user, Integer userId) {
		userRegistration existingUserRegistration = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("userRegistration", "userId", userId));
		existingUserRegistration.setFirstName(user.getFirstName());
		existingUserRegistration.setLastName(user.getLastName());
		existingUserRegistration.setGender(user.getGender());
		existingUserRegistration.setAge(user.getAge());
		existingUserRegistration.setEmail(user.getEmail());
		existingUserRegistration.setAddress(user.getAddress());
		existingUserRegistration.setMobileNo(user.getMobileNo());
		existingUserRegistration.setPassword(user.getPassword());
		existingUserRegistration.setConfirmPassword(user.getConfirmPassword());
		existingUserRegistration.setRole(user.getRole());
		userRepository.save(existingUserRegistration);
		return existingUserRegistration;
		
	}

	@Override
	public void deleteuserRegistration(Integer userId) {
		//check whether a user exist or not in a database
		userRepository.findById(userId).orElseThrow(() -> 
		new ResourceNotFoundException("userRegistration", "userId", userId));
		userRepository.deleteById(userId);
	}
	
}
 