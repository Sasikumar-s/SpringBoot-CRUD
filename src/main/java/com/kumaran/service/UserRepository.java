package com.kumaran.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumaran.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
