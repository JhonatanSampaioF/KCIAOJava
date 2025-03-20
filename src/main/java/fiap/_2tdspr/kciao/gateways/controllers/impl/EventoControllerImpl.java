package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.EventoController;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudEventoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventoControllerImpl implements EventoController {

    private final CrudEventoImpl crudEvento;

    @Override
    public ResponseEntity<EventoResponseDto> getEvento(String id) {

        EventoResponseDto eventoResponseDto = crudEvento.getOne(id);

        return ResponseEntity.ok(eventoResponseDto);
    }

    @Override
    public ResponseEntity<List<EventoResponseDto>> getAllEvento() {

        List<EventoResponseDto> eventoResponseDtoList = crudEvento.getAll();

        return ResponseEntity.ok(eventoResponseDtoList);
    }

    @Override
    public ResponseEntity<EventoResponseDto> criarEvento(EventoRequestPostDto evento) {

        EventoResponseDto eventoSalvo = crudEvento.save(evento);

        return ResponseEntity.ok(eventoSalvo);
    }

    @Override
    public ResponseEntity<EventoResponseDto> atualizarEvento(String id, EventoRequestPatchDto eventoRequestPatchDto) {

        EventoResponseDto eventoResponseDto = crudEvento.update(id, eventoRequestPatchDto);

        return ResponseEntity.ok(eventoResponseDto);
    }

    @Override
    public void deletarEvento(String id) {
        crudEvento.delete(id);
    }
}
