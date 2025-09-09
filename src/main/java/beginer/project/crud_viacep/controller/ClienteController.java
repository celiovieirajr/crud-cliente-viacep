package beginer.project.crud_viacep.controller;

import beginer.project.crud_viacep.dto.ClienteRequestDto;
import beginer.project.crud_viacep.dto.ClienteResponseDto;
import beginer.project.crud_viacep.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ClienteResponseDto insertClientController(@RequestBody ClienteRequestDto requestDto) {
        return service.insertClient(requestDto);
    }

    @GetMapping
    public List<ClienteResponseDto> getAllClientsController() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto findClientByIdController(@PathVariable long id) {
        return service.findClientById(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDto updateClientByIdController(@PathVariable long id,
                                                         @RequestBody ClienteRequestDto requestDto) {
        return service.updateClientById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClientByIdController(@PathVariable long id) {
        service.deleteClientById(id);
    }
}
