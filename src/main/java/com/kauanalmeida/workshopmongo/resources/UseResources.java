package com.kauanalmeida.workshopmongo.resources;

import com.kauanalmeida.workshopmongo.domain.User;
import com.kauanalmeida.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UseResources {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll(){
        List<User> list = service.findAll();
        return list;
    }
}
