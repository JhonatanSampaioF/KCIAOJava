package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.cliente.ClienteRequestDto;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public interface ClienteController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClienteResponseDto> getCliente(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClienteResponseDto>> getAllCliente();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClienteResponseDto> criarCliente(@RequestBody @Valid ClienteRequestDto cliente);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<ClienteResponseDto>> atualizarCliente(@PathVariable @Valid String id, @RequestBody @Valid ClienteRequestDto clienteRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarCliente(@PathVariable @Valid String id);

    @GetMapping("/{id}/eventos")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<EventoResponseDto>> getAllEventos(@PathVariable @Valid String id);
}
