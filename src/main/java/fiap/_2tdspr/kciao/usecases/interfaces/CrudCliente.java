package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudCliente {
    void save(ClienteRequestDto clienteRequestDto);
    void update(Long id, ClienteRequestDto clienteRequestDto);
    void delete(Long id);
}
