package beginer.project.crud_viacep.service;

import beginer.project.crud_viacep.dto.ClienteRequestDto;
import beginer.project.crud_viacep.dto.ClienteResponseDto;
import beginer.project.crud_viacep.model.Cliente;
import beginer.project.crud_viacep.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDto insertClient(ClienteRequestDto requestDto) {
        Cliente model = toModel(requestDto);
        Cliente clientSaved = clienteRepository.save(model);

        return toResponse(clientSaved);
    }

    public List<ClienteResponseDto> getAllClients() {
        return clienteRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ClienteResponseDto findClientById(Long id) {
        return clienteRepository.findById(id).map(this::toResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID cliente não encontrado."));
    }

    public ClienteResponseDto updateClientById(Long id, ClienteRequestDto requestDto) {
        Cliente model = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID cliente não encontrado, não pode ser alterado."));

        model.setNome(requestDto.getNome());
        model.setEndereco(requestDto.getEndereco());
        model.setUltimaDataModificada(new Timestamp(System.currentTimeMillis()));

        Cliente clientSaved = clienteRepository.save(model);

        return toResponse(clientSaved);
    }

    public void deleteClientById(long id) {
        Cliente clienteId = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "ID do cliente não encontrado, não pode ser deletado."));

        clienteRepository.delete(clienteId);
    }

    private Cliente toModel(ClienteRequestDto requestDto) {
        Cliente model = new Cliente();
        model.setEndereco(requestDto.getEndereco());
        model.setNome(requestDto.getNome());
        model.setUltimaDataModificada(new Timestamp(System.currentTimeMillis()));

        return model;
    }

    private ClienteResponseDto toResponse(Cliente model) {
        ClienteResponseDto responseDto = new ClienteResponseDto();
        responseDto.setId(model.getId());
        responseDto.setEndereco(model.getEndereco());
        responseDto.setNome(model.getNome());
        responseDto.setUltimaDataModificada(model.getUltimaDataModificada());

        return responseDto;
    }
}
