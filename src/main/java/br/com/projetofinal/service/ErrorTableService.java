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
                            String descricao_do_evento,
                            String log_do_evento,
                            String origem,
                            LocalDateTime data_do_evento,
                            Long quantidade,
                            int page,
                            int size,
                            String ordem);
   ErrorTable save(ErrorTable errorLog);
}
