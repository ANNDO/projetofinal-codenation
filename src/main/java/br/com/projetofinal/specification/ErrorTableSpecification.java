package br.com.projetofinal.specification;

import br.com.projetofinal.entity.ErrorTable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ErrorTableSpecification {

    public static Specification<ErrorTable> level (String level){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("level"),level);

    }
    public static Specification<ErrorTable> descricaoDoEvento (String descricaoDoEvento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("descricaoDoEvento"),descricaoDoEvento);
    }
    public static Specification<ErrorTable> logDoEvento (String logDoEvento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("logDoEvento"),logDoEvento);
    }
    public static Specification<ErrorTable> origem (String origem){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("origem"),origem);
    }
    public static Specification<ErrorTable> dataDoEvento (LocalDateTime dataDoEvento){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("dataDoEvento"),dataDoEvento);
    }
    public static Specification<ErrorTable> quantidade (Long quantidade){
        return (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("quantidade"),quantidade);
    }


}
