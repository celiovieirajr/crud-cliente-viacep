package beginer.project.crud_viacep.dto;

import beginer.project.crud_viacep.model.Viacep;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
public class ClienteRequestDto {

    private String nome;
    private Timestamp ultimaDataModificada;
    private Viacep endereco;
}

