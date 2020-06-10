package br.com.projetofinal.controller;

import br.com.projetofinal.ProjetofinalApplication;
import br.com.projetofinal.entity.ErrorTable;
import br.com.projetofinal.service.ErrorTableService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/errorstable")
public class ErrorTableController {

    @Autowired
    private ErrorTableService errorTableService;

    private static Logger logger = LoggerFactory.getLogger(ProjetofinalApplication.class);

    @PostMapping
    public ResponseEntity<ErrorTable> create(@RequestBody ErrorTable errorLog){
            return new ResponseEntity<ErrorTable>(this.errorTableService.save(errorLog), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ErrorTable> findAll(Pageable pageable){
        logger.info("Eita lasquera");
        return this.errorTableService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Optional<ErrorTable> findErrorById(@PathVariable("id") Long errorId){
        return this.errorTableService.findErrorById(errorId);
    }
}
