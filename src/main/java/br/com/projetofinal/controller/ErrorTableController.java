package br.com.projetofinal.controller;

import br.com.projetofinal.ProjetofinalApplication;
import br.com.projetofinal.dto.ErrorTableDTO;
import br.com.projetofinal.entity.ErrorTable;
import br.com.projetofinal.mapper.ErrorTableMapper;
import br.com.projetofinal.service.ErrorTableService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/errorstable")
@Validated
public class ErrorTableController {


    private ErrorTableService errorTableService;


    private ErrorTableMapper errorTableMapper;

    private static Logger logger = LoggerFactory.getLogger(ProjetofinalApplication.class);

    public boolean verifyLogLevel(ErrorTable errorLog) {
        JSONObject jsonrequest = new JSONObject(errorLog);
        String logLevel = jsonrequest.get("level").toString().toUpperCase();
        return logLevel.equals("INFO") || logLevel.equals("WARNING") || logLevel.equals("ERROR");

    }

    @PostMapping
    @ApiOperation("Post de um novo log. Permite os seguintes level logs: warning,info e error.")
    public ResponseEntity<ErrorTable> create(@Valid @RequestBody ErrorTable errorLog){
            if(verifyLogLevel(errorLog)){
                return new ResponseEntity<ErrorTable>(this.errorTableService.save(errorLog), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<ErrorTable>(HttpStatus.BAD_REQUEST);

            }
    }

    @GetMapping("/all/search")
    @ApiOperation("Busca de registro através dos valores dos campos. Não retorna o campo 'log_do_evento'. Permite ordenação.")
    public Page<ErrorTableDTO> findAll(@RequestParam(value="level", required = false) String level,
                                    @RequestParam(value = "descricao_doevento",required = false) String descricao_do_evento,
                                    @RequestParam(value = "log_do_evento", required = false) String log_do_evento,
                                    @RequestParam(value = "origem", required = false) String origem,
                                    @RequestParam(value = "data_do_evento", required = false) LocalDateTime data_do_evento,
                                    @RequestParam(value="quantidade", required = false) Long quantidade,
                                    @RequestParam(value = "page",required = false, defaultValue = "0") int page,
                                    @RequestParam(value = "size",required = false,defaultValue = "10") int size,
                                    @RequestParam(value = "ordenar", required = false,defaultValue = "id") String ordem) {

        return this.errorTableService
                .findAll(level,descricao_do_evento,log_do_evento,origem,data_do_evento,quantidade,page,size,ordem)
                .map(errorTable ->  errorTableMapper.map(errorTable));
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna um log através de seu Id.")
    public Optional<ErrorTable> findErrorById(@PathVariable("id") Long errorId){
        return  this.errorTableService.findErrorById(errorId);
    }
}
