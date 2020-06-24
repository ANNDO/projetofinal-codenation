package br.com.projetofinal.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
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
    private String descricaoDoEvento;

    @NotNull
    @NotBlank(message = "O campo log_do_evento é mandatório.")
    private String logDoEvento;

    @NotNull
    @NotBlank(message = "O campo origem é mandatório.")
    private String origem;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "O campo data_do_evento é mandatório.")
    private LocalDateTime dataDoEvento;

    @NotNull(message = "O campo quantidade é mandatório.")
    @Positive
    private Long quantidade;


}
