package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudEvento {
    EventoResponseDto save(EventoRequestPostDto eventoRequestPostDto);
    EventoResponseDto getOne(String id);
    List<EventoResponseDto> getAll();
    EventoResponseDto update(String id, EventoRequestPatchDto eventoRequestPatchDto);
    void delete(String id);
}
