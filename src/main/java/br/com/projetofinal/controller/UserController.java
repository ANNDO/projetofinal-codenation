package br.com.projetofinal.controller;


import br.com.projetofinal.controller.advice.UserAdvice;
import br.com.projetofinal.entity.User;
import br.com.projetofinal.service.UserService;
import io.swagger.annotations.ApiOperation;
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

    private  UserAdvice userAdvice;


    @PostMapping("/register")
    @ApiOperation("Salva dados de novo usuário.")
    public ResponseEntity<User> save (@Valid @RequestBody User user){
        if(!(userService.findByUsername(user.getUsername()))){
            return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }

    }




}
