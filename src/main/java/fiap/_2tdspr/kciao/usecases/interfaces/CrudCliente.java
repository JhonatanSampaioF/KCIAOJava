package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudCliente {
    ClienteResponseDto save(ClienteRequestDto clienteRequestDto);
    Optional<ClienteResponseDto> getOne(String id);
    List<ClienteResponseDto> getAll();
    Optional<ClienteResponseDto> update(String id, ClienteRequestDto clienteRequestDto);
    void delete(String id);
}
