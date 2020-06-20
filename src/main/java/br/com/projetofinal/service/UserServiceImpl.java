package br.com.projetofinal.service;

import br.com.projetofinal.entity.User;
import br.com.projetofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private void verifyUserRegistration(User user){
        if(this.userRepository.findByUsername(user.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @Override
    public User save(User user) {
        verifyUserRegistration(user);
        return this.userRepository.save(user) ;
    }
}
