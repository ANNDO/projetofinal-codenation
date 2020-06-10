package br.com.projetofinal.service;

import br.com.projetofinal.entity.ErrorTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ErrorTableService {

   Optional<ErrorTable> findErrorById(Long id);
   List<ErrorTable> findAll(Pageable pageable);
   ErrorTable save(ErrorTable erroLog);
}
