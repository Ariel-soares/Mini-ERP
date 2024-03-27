package com.arielSoares.WebSystem.repositories;

import com.arielSoares.WebSystem.entities.Client;
import com.arielSoares.WebSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
