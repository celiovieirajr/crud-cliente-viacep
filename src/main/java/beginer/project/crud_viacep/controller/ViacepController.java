package beginer.project.crud_viacep.controller;

import beginer.project.crud_viacep.dto.ViacepResponseDto;
import beginer.project.crud_viacep.ingestion.ViaCepWebClient;
import beginer.project.crud_viacep.model.Viacep;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep")
@AllArgsConstructor
public class ViacepController {

    private final ViaCepWebClient webClient;

    @GetMapping("/{cep}")
    public ResponseEntity<ViacepResponseDto> getViacepController(@PathVariable String cep) {
        ViacepResponseDto resposta = webClient.getViacep(cep);
        return ResponseEntity.ok(resposta);
    }
}
