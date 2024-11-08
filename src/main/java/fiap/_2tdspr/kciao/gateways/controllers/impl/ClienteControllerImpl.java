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
    public void criarCliente(ClienteRequestDto cliente) {
        crudCliente.save(cliente);
    }

    @Override
    public void atualizarCliente(Long id, ClienteRequestDto clienteRequestDto) {
        crudCliente.update(id, clienteRequestDto);
    }

    @Override
    public void deletarCliente(Long id) {
        crudCliente.delete(id);
    }
}
