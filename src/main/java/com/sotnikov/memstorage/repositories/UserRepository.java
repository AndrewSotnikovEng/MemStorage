package com.sotnikov.memstorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sotnikov.memstorage.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
