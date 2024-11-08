package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public interface ClienteController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criarCliente(@RequestBody @Valid ClienteRequestDto cliente);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void atualizarCliente(@PathVariable @Valid Long id, @RequestBody @Valid ClienteRequestDto clienteRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarCliente(@PathVariable @Valid Long id);
}
