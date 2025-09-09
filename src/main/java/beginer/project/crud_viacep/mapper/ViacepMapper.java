package beginer.project.crud_viacep.mapper;

import beginer.project.crud_viacep.dto.ViacepRequestDto;
import beginer.project.crud_viacep.dto.ViacepResponseDto;
import beginer.project.crud_viacep.model.Viacep;
import org.springframework.stereotype.Component;

@Component
public class ViacepMapper {

    public Viacep toModel(ViacepRequestDto dto) {
        Viacep model = new Viacep();
        model.setCep(dto.getCep());
        model.setLogradouro(dto.getLogradouro());
        model.setBairro(dto.getBairro());
        model.setComplemento(dto.getComplemento());
        model.setUnidade(dto.getUnidade());
        model.setLocalidade(dto.getLocalidade());
        model.setUf(dto.getUf());
        model.setEstado(dto.getEstado());
        model.setRegiao(dto.getRegiao());
        model.setIbge(dto.getIbge());

        return model;
    }

    public ViacepResponseDto toResponse(Viacep model) {
        ViacepResponseDto responseDto = new ViacepResponseDto();
        responseDto.setCep(model.getCep());
        responseDto.setBairro(model.getBairro());
        responseDto.setEstado(model.getEstado());
        responseDto.setComplemento(model.getComplemento());
        responseDto.setLocalidade(model.getLocalidade());
        responseDto.setUf(model.getUf());
        responseDto.setUnidade(model.getUnidade());
        responseDto.setIbge(model.getIbge());
        responseDto.setLogradouro(model.getLogradouro());

        return responseDto;
    }
}
