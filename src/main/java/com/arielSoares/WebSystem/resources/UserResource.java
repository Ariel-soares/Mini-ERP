package com.arielSoares.WebSystem.resources;

import com.arielSoares.WebSystem.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "ariel", "rua 1", true, "ariel", "123");
        return ResponseEntity.ok().body(u);
    }

}
