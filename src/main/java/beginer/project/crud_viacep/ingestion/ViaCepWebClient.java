package beginer.project.crud_viacep.ingestion;

import beginer.project.crud_viacep.model.Viacep;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ViaCepWebClient {

    private final WebClient webClient;

    public ViaCepWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Viacep getViacep(String cep) {
        return webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(Viacep.class)
                .block();
    }
}
