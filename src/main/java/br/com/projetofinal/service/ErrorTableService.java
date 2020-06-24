package br.com.projetofinal.service;

import br.com.projetofinal.entity.ErrorTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ErrorTableService {

   Optional<ErrorTable> findErrorById(Long id);
   Page<ErrorTable> findAll(String level,
                            String descricaoDoEvento,
                            String logDoEvento,
                            String origem,
                            LocalDateTime dataDoEvento,
                            Long quantidade,
                            int page,
                            int size,
                            String ordem);
   ErrorTable save(ErrorTable errorLog);
}
