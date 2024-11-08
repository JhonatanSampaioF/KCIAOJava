package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.gateways.controllers.interfaces.ClienteController;
import fiap._2tdspr.kciao.gateways.repositories.ClienteRepository;
import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class CrudClienteImpl implements CrudCliente {
    private final ClienteRepository clienteRepository;
    @Override
    public void save(ClienteRequestDto clienteRequestDto) {

        Cliente clienteASerCriado = Cliente.builder()
                .nm_cliente(clienteRequestDto.getNm_cliente())
                .build();

        clienteRepository.save(clienteASerCriado);
    }

    @Override
    public void update(Long id, ClienteRequestDto clienteRequestDto) {

        Cliente clienteASerAtualizado = Cliente.builder()
                .nm_cliente(clienteRequestDto.getNm_cliente())
                .build();

        clienteRepository.updateCliente(
                id,
                clienteASerAtualizado.getNm_cliente()
        );
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteCliente(id);
    }
}
