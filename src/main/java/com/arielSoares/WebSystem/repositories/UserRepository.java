package com.arielSoares.WebSystem.repositories;

import com.arielSoares.WebSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
