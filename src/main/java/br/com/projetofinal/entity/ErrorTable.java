package br.com.projetofinal.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Data
@Entity
public class ErrorTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "O campo 'level' é mandatório.")
    private String level;

    @NotNull
    @NotBlank(message = "O campo descricao_do_evento é mandatório.")
    private String descricao_do_evento;

    @NotNull
    @NotBlank(message = "O campo log_do_evento é mandatório.")
    private String log_do_evento;

    @NotNull
    private String origem;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime data_do_evento;

    @NotNull
    @PositiveOrZero
    private Long quantidade;



}
