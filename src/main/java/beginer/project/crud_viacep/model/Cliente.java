package beginer.project.crud_viacep.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;

@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Timestamp ultimaDataModificada;

    @Embedded
    private Viacep endereco;
}