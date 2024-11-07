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
    public ClienteResponseDto save(ClienteRequestDto clienteRequestDto) {

        Cliente clienteASerCriado = Cliente.builder()
                .nm_cliente(clienteRequestDto.getNm_cliente())
                .build();

        Cliente clienteSalvo = clienteRepository.save(clienteASerCriado);

        ClienteResponseDto clienteResponse = ClienteResponseDto.builder()
                .nm_cliente(clienteSalvo.getNm_cliente())
                .build();

        clienteResponse.add(
                linkTo(
                        methodOn(ClienteController.class)
                                .getCliente(clienteSalvo.getId_cliente().toString())
                ).withSelfRel()
        );

        return clienteResponse;
    }

    @Override
    public Optional<ClienteResponseDto> getOne(String id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            ClienteResponseDto clienteResponse = ClienteResponseDto.builder()
                    .nm_cliente(cliente.get().getNm_cliente())
                    .build();
            return Optional.of(clienteResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<ClienteResponseDto> getAll() {
        List<Cliente> listCliente = clienteRepository.findAll();
        List<ClienteResponseDto> listClienteResponse = listCliente.stream()
                .map(cliente -> ClienteResponseDto.builder()
                        .nm_cliente(cliente.getNm_cliente())
                        .build()).toList();
        return listClienteResponse;
    }

    @Override
    public Optional<ClienteResponseDto> update(String id, ClienteRequestDto clienteRequestDto) {

        Cliente clienteASerAtualizado = Cliente.builder()
                .nm_cliente(clienteRequestDto.getNm_cliente())
                .build();

        int clienteAtualizado = clienteRepository.updateById_cliente(
                clienteASerAtualizado.getNm_cliente(),
                id
        );

        if(clienteAtualizado != 0){
            Optional<ClienteResponseDto> clienteAtualizadoResponse = getOne(id);
            if(clienteAtualizadoResponse.isPresent()){
                ClienteResponseDto clienteResponse = ClienteResponseDto.builder()
                        .nm_cliente(clienteAtualizadoResponse.get().getNm_cliente())
                        .build();
                return Optional.ofNullable(clienteResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(String id) {
        clienteRepository.deleteById(id);
    }
}
