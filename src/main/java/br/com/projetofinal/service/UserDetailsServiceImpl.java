package br.com.projetofinal.service;

import br.com.projetofinal.entity.User;
import br.com.projetofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.userRepository.findByUsername(username).isPresent()){
            return new UserDetailsImpl(this.userRepository.findByUsername(username).get());
        }
        throw new UsernameNotFoundException("username: "+ username+ "não cadastrado.");

    }


}
