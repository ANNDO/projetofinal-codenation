package br.com.projetofinal.service;

import br.com.projetofinal.entity.ErrorTable;
import br.com.projetofinal.repository.ErrorTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ErrorTableServiceImpl implements ErrorTableService {

    @Autowired
    private ErrorTableRepository errorTableRepository;

    @Override
    public List<ErrorTable> findAll(Pageable pageable){
        return this.errorTableRepository.findAll(pageable).getContent();
    }

    @Override
    public ErrorTable save(ErrorTable erroLog) {
        return this.errorTableRepository.save(erroLog);
    }

    @Override
    public Optional<ErrorTable> findErrorById(Long id) {
        return this.errorTableRepository.findErrorById(id);
    }
}
