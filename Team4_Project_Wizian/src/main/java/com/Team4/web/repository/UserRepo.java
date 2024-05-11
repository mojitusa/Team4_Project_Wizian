package com.Team4.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.Users;

public interface UserRepo extends JpaRepository<Users, String>{

}
