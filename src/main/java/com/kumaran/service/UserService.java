package com.kumaran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kumaran.model.User;
@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;
	public List<User> listAll(){
		return repo.findAll();
		
	}
	public User addUser(User user) {
		return repo.save(user);
	}
	public User get(int id) {
		return repo.getById(id);
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}
