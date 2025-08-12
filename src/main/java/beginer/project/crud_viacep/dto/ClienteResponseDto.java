package beginer.project.crud_viacep.dto;

import beginer.project.crud_viacep.model.Viacep;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ClienteResponseDto {

    private long id;
    private String nome;
    private Timestamp ultimaDataModificada;
    private Viacep endereco;
}