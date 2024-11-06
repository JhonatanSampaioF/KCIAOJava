package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDataDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDescricaoDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchTipoDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudEvento {
    EventoResponseDto save(EventoRequestPostDto eventoRequestPostDto);
    Optional<EventoResponseDto> getOne(String id);
    List<EventoResponseDto> getAll();
    Optional<EventoResponseDto> updateData(String id, EventoRequestPatchDataDto eventoRequestPatchDataDto);
    Optional<EventoResponseDto> updateDescricao(String id, EventoRequestPatchDescricaoDto eventoRequestPatchDescricaoDto);
    Optional<EventoResponseDto> updateTipo(String id, EventoRequestPatchTipoDto eventoRequestPatchTipoDto);
    void delete(String id);
}
