package com.Team4.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.User;

public interface AddAccountUserRepo extends JpaRepository<User, String>{

}
