package com.inhouse.trackthefood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inhouse.trackthefood.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
