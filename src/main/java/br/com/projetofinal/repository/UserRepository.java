package br.com.projetofinal.repository;

import br.com.projetofinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);



}
