package br.com.projetofinal.controller;


import br.com.projetofinal.entity.User;
import br.com.projetofinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<User> save (@Valid @RequestBody User user){
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);    }



}
