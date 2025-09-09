package beginer.project.crud_viacep.mapper;

import beginer.project.crud_viacep.dto.ClienteRequestDto;
import beginer.project.crud_viacep.dto.ClienteResponseDto;
import beginer.project.crud_viacep.model.Cliente;
import beginer.project.crud_viacep.model.Viacep;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class ClienteMapper {

    public Cliente toModel(ClienteRequestDto dto) {
        Cliente model = new Cliente();
        model.setNome(dto.getNome());
        model.setUltimaDataModificada(Timestamp.valueOf(LocalDateTime.now()));

        if (dto.getEndereco() != null) {
            Viacep endereco = new Viacep();
            endereco.setCep(dto.getEndereco().getCep());
            endereco.setBairro(dto.getEndereco().getBairro());
            endereco.setUf(dto.getEndereco().getUf());
            endereco.setDdd(dto.getEndereco().getDdd());
            endereco.setEstado(dto.getEndereco().getEstado());
            endereco.setGia(dto.getEndereco().getGia());
            endereco.setIbge(dto.getEndereco().getIbge());
            endereco.setComplemento(dto.getEndereco().getComplemento());
            endereco.setUf(dto.getEndereco().getUf());
            endereco.setBairro(dto.getEndereco().getBairro());
            model.setEndereco(endereco);
        }

        return model;
    }

    public ClienteResponseDto toResponse(Cliente model) {
        ClienteResponseDto response = new ClienteResponseDto();
        response.setId(model.getId());
        response.setNome(model.getNome());
        response.setUltimaDataModificada(model.getUltimaDataModificada());
        response.setEndereco(model.getEndereco());

        return response;
    }

}
