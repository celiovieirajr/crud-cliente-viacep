package beginer.project.crud_viacep.dto;

import beginer.project.crud_viacep.model.Viacep;

import java.sql.Timestamp;


public class ClienteResponseDto {

    private long id;
    private String nome;
    private Timestamp ultimaDataModificada;
    private Viacep endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getUltimaDataModificada() {
        return ultimaDataModificada;
    }

    public void setUltimaDataModificada(Timestamp ultimaDataModificada) {
        this.ultimaDataModificada = ultimaDataModificada;
    }

    public Viacep getEndereco() {
        return endereco;
    }

    public void setEndereco(Viacep endereco) {
        this.endereco = endereco;
    }
}