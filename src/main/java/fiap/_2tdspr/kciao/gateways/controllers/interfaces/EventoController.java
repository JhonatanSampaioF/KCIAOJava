package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public interface EventoController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<EventoResponseDto> getEvento(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<EventoResponseDto>> getAllEvento();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EventoResponseDto> criarEvento(@RequestBody @Valid EventoRequestPostDto evento);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<EventoResponseDto> atualizarEvento(@PathVariable @Valid String id, @RequestBody @Valid EventoRequestPatchDto eventoRequestPatchDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarEvento(@PathVariable @Valid String id);
}
