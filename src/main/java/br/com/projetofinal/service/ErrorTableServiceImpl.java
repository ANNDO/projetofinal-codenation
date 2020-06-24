package br.com.projetofinal.service;

import br.com.projetofinal.controller.advice.ErrorTableAdvice;
import br.com.projetofinal.entity.ErrorTable;
import br.com.projetofinal.repository.ErrorTableRepository;
import br.com.projetofinal.specification.ErrorTableSpecification;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.OrderBy;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ErrorTableServiceImpl implements ErrorTableService {

    @Autowired
    private ErrorTableRepository errorTableRepository;


    @Override
    public Page<ErrorTable> findAll(String level,
                                    String descricaoDoEvento,
                                    String logDoEvento,
                                    String origem,
                                    LocalDateTime dataDoEvento,
                                    Long quantidade,
                                    int page,
                                    int size,
                                    String ordem){
        PageRequest pageRequest = PageRequest.of(page,size,Sort.by(ordem));

        return this.errorTableRepository.findAll(
                Specification.where(ErrorTableSpecification.level(level))
                .or(ErrorTableSpecification.descricaoDoEvento(descricaoDoEvento))
                .or(ErrorTableSpecification.logDoEvento(logDoEvento))
                .or(ErrorTableSpecification.origem(origem))
                .or(ErrorTableSpecification.dataDoEvento(dataDoEvento))
                .or(ErrorTableSpecification.quantidade(quantidade)),pageRequest);
    }

    @Override
    public ErrorTable save(ErrorTable errorLog) {
        return this.errorTableRepository.save(errorLog);
    }

    @Override
    public Optional<ErrorTable> findErrorById(Long id) {
        return this.errorTableRepository.findErrorById(id);
    }
}
