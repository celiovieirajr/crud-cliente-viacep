package beginer.project.crud_viacep.controller;

import beginer.project.crud_viacep.ingestion.ViaCepWebClient;
import beginer.project.crud_viacep.model.Viacep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep")
public class ViacepController {

    private final ViaCepWebClient webClient;

    public ViacepController(ViaCepWebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/{cep}")
    public Viacep getViacepController(@PathVariable String cep) {
        return webClient.getViacep(cep);
    }
}
