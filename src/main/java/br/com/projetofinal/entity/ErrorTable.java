package br.com.projetofinal.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class ErrorTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String level;

    private String descricao_do_evento;

    private String log_do_evento;

    private String origem;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime data_do_evento;

    private Long quantidade;



}
