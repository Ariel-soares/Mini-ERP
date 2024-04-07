package com.arielSoares.WebSystem.services;

import com.arielSoares.WebSystem.entities.User;
import com.arielSoares.WebSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id,  User user){
        User obj = repository.getReferenceById(id);
        updateData(obj, user);
        return repository.save(obj);
    }

    private void updateData(User obj, User user) {
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setPassword(user.getPassword());
    }

}
