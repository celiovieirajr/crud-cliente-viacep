package beginer.project.crud_viacep.ingestion;

import beginer.project.crud_viacep.model.Viacep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@AllArgsConstructor
public class ViaCepWebClient {

    private final WebClient webClient;

    public Viacep getViacep(String cep) {
        return webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(Viacep.class)
                .block();
    }
}
