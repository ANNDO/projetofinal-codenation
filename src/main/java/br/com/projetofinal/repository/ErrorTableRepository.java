package br.com.projetofinal.repository;

import br.com.projetofinal.entity.ErrorTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ErrorTableRepository extends JpaRepository<ErrorTable,Long>, JpaSpecificationExecutor<ErrorTable> {

    Page<ErrorTable> findAll(Pageable pageable);

    @Query(value = "select * from error_table where id = :errorId ",nativeQuery = true)
    Optional<ErrorTable> findErrorById(@Param("errorId")Long errorId);

}
