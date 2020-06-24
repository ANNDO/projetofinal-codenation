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

    public boolean findByUsername(String username){
        return this.userRepository.findByUsername(username).isPresent();

    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user) ;
    }
}
