package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.ClienteController;
import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudClienteImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final CrudClienteImpl crudCliente;

    @Override
    public ResponseEntity<ClienteResponseDto> getCliente(String id) {

        ClienteResponseDto clienteResponseDto = crudCliente.getOne(id);

        return ResponseEntity.ok(clienteResponseDto);
    }

    @Override
    public ResponseEntity<List<ClienteResponseDto>> getAllCliente() {

        List<ClienteResponseDto> clienteResponseDtoList = crudCliente.getAll();

        return ResponseEntity.ok(clienteResponseDtoList);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> criarCliente(ClienteRequestDto cliente) {

        ClienteResponseDto clienteSalvo = crudCliente.save(cliente);

        return ResponseEntity.ok(clienteSalvo);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> atualizarCliente(String id, ClienteRequestDto clienteRequestDto) {

        ClienteResponseDto clienteResponseDto = crudCliente.update(id, clienteRequestDto);

        return ResponseEntity.ok(clienteResponseDto);
    }

    @Override
    public void deletarCliente(String id) {
        crudCliente.delete(id);
    }

    @Override
    public ResponseEntity<List<EventoResponseDto>> getAllEventos(String id) {
        List<EventoResponseDto> eventoResponseDtoList = crudCliente.getAllEventos(id);

        return ResponseEntity.ok(eventoResponseDtoList);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> adicionarDoenca(String idCliente, String idDoenca) {
        return ResponseEntity.ok(crudCliente.addDoenca(idCliente,idDoenca));
    }

    @Override
    public ResponseEntity<ClienteResponseDto> removerDoenca(String idCliente, String idDoenca) {
        return ResponseEntity.ok(crudCliente.removeDoenca(idCliente,idDoenca));
    }
}
