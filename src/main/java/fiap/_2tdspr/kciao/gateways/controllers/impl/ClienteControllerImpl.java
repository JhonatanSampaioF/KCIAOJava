package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.ClienteController;
import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudClienteImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final CrudClienteImpl crudCliente;

    @Override
    public ResponseEntity<Optional<ClienteResponseDto>> getCliente(String id) {

        Optional<ClienteResponseDto> clienteResponseDto = crudCliente.getOne(id);

        return ResponseEntity.of(Optional.of(clienteResponseDto));
    }

    @Override
    public ResponseEntity<List<ClienteResponseDto>> getAllCliente() {

        List<ClienteResponseDto> clienteResponseDtoList = crudCliente.getAll();

        return ResponseEntity.ok(clienteResponseDtoList);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> criarCliente(ClienteRequestDto cliente) {

        ClienteResponseDto clienteSalvo = crudCliente.save(cliente);

        return ResponseEntity.of(Optional.of(clienteSalvo));
    }

    @Override
    public ResponseEntity<Optional<ClienteResponseDto>> atualizarCliente(String id, ClienteRequestDto clienteRequestDto) {

        Optional<ClienteResponseDto> clienteResponseDto = crudCliente.update(id, clienteRequestDto);

        return ResponseEntity.of(Optional.of(clienteResponseDto));
    }

    @Override
    public void deletarCliente(String id) {
        crudCliente.delete(id);
    }
}
