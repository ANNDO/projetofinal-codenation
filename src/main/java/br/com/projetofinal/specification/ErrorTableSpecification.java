package br.com.projetofinal.specification;

import br.com.projetofinal.entity.ErrorTable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ErrorTableSpecification {

    public static Specification<ErrorTable> level (String level){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("level"),level);

    }
    public static Specification<ErrorTable> descricao_do_evento (String descricao_do_evento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("descricao_do_evento"),descricao_do_evento);
    }
    public static Specification<ErrorTable> log_do_evento (String log_do_evento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("log_do_evento"),log_do_evento);
    }
    public static Specification<ErrorTable> origem (String origem){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("origem"),origem);
    }
    public static Specification<ErrorTable> data_do_evento (LocalDateTime data_do_evento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("descricao_do_evento"),data_do_evento);
    }
    public static Specification<ErrorTable> quantidade (Long quantidade){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("quantidade"),quantidade);
    }


}
