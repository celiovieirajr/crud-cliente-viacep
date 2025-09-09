package beginer.project.crud_viacep.ingestion;

import beginer.project.crud_viacep.dto.ViacepResponseDto;
import beginer.project.crud_viacep.mapper.ViacepMapper;
import beginer.project.crud_viacep.model.Viacep;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ViaCepWebClient {

    @Autowired
    private WebClient webClient;

    @Autowired
    private ViacepMapper mapper;

    public ViacepResponseDto getViacep(String cep) {
        Viacep model = webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(Viacep.class)
                .block();
        return mapper.toResponse(model);
    }
}
