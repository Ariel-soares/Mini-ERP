package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.Client;
import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.ClientRepository;
import com.arielSoares.WebSystem.services.exceptions.DatabaseException;
import com.arielSoares.WebSystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client insert(Client client){
        return repository.save(client);
    }

    public void delete(Long id){
        try {
            if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
            repository.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Client update(Long id, Client obj){
        Client client = repository.getReferenceById(id);
        updateData(client, obj);
        return repository.save(client);
    }

    private void updateData(Client client, Client obj) {
        client.setName(obj.getName());
        client.setAddress(obj.getAddress());
        client.setPhone(obj.getPhone());
        client.setEmail(obj.getEmail());
        client.setDetails(obj.getDetails());
    }

}
