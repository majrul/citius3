package com.gl.demos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.demos.entity.Users;
import com.gl.demos.repository.UsersRepository;


/**
 * 
 * @author Shalini
 * Service class that communicates with the database layer and provides
 * implementation for all the crud operations for Users. 
 * Code throws proper exceptions wherever required
 */
@Service
public class UsersService {
	
	// Users service has a dependency on the UsersRepository
	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * 
	 * @return the list of all the available Users
	 */
	public List<Users> getAllUserss()
	{
		List<Users> users = new ArrayList<>();
		this.usersRepository.findAll().forEach(Users->users.add(Users));
		return users;
	}
	/**
	 * 
	 * @param email the id of the Users to fetch the Users details
	 * @return the Users retrieved if found by id or else throws exception
	 */
	public Users getUsersByEmail(String email)
	{
		return this.usersRepository
				.findById(email)
				.orElseThrow(()-> new EntityNotFoundException("Users with id "+email+" does not exist"));
	}
	/**
	 * 
	 * @param email the id of the existing Users to update
	 * @return true of Users was found and updated successfully else throws an exception
	 */
	
	public boolean updateUser(Users user)
	{
		if(!this.usersRepository.existsById(user.getEmail()))
			throw new EntityNotFoundException("Users with id "+user.getEmail()+" does not exist and cannot be updated");	
		else {
			this.usersRepository.save(user);
			return true;
		}
	}
	/**
	 * 
	 * @param Usersid the id of the Users to delete
	 * @return true if Users is deleted successfully, else throws an exception
	 */
	public boolean deleteUsersByEmail(String email)
	{

		if(!this.usersRepository.existsById(email))
			throw new EntityNotFoundException("Users with id "+email+" does not exist and cannot be deleted");	
		else {
			this.usersRepository.deleteById(email);
			return true;
		}
	}
	/**
	 * 
	 * @param Users the Users to be added
	 * @return true if Users was successfully inserted else throws an exception
	 */
	public boolean addUsers(Users user)
	{
		if(this.usersRepository.existsById(user.getEmail()))
			throw new EntityNotFoundException("Users with id "+user.getEmail()+" already exists and cannot be added");	
		else {
			this.usersRepository.save(user);
			return true;
		}
	}

}
