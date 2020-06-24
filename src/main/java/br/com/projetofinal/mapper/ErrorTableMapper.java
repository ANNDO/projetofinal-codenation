package br.com.projetofinal.mapper;

import br.com.projetofinal.dto.ErrorTableDTO;
import br.com.projetofinal.entity.ErrorTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ErrorTableMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "level",target = "level"),
            @Mapping(source = "descricaoDoEvento",target = "descricaoDoEvento"),
            @Mapping(source = "origem",target = "origem"),
            @Mapping(source = "dataDoEvento",target = "dataDoEvento", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "quantidade",target = "quantidade")
    })
   ErrorTableDTO map(ErrorTable errorTable);
    List<ErrorTableDTO> map (List<ErrorTable> ferrorTable);


}
