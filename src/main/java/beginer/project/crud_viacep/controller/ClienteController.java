package beginer.project.crud_viacep.controller;

import beginer.project.crud_viacep.dto.ClienteRequestDto;
import beginer.project.crud_viacep.dto.ClienteResponseDto;
import beginer.project.crud_viacep.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> insertClientController(@RequestBody ClienteRequestDto requestDto) {
        ClienteResponseDto response = service.insertClient(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getAllClientsController() {
        List<ClienteResponseDto> responseList = service.getAllClients();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findClientByIdController(@PathVariable long id) {
        ClienteResponseDto response = service.findClientById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> updateClientByIdController(@PathVariable long id,
                                                                         @RequestBody ClienteRequestDto requestDto) {
        ClienteResponseDto response = service.updateClientById(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientByIdController(@PathVariable long id) {
        service.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}
