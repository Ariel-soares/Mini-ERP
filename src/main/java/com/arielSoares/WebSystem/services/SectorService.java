package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.Sector;
import com.arielSoares.WebSystem.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    private SectorRepository repository;

    public List<Sector> findAll(){
        return repository.findAll();
    }

    public Sector findById(Long id){
        Optional<Sector> obj = repository.findById(id);
        return obj.get();
    }

}
