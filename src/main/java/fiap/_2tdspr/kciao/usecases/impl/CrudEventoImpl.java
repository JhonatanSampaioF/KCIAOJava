package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Evento;
import fiap._2tdspr.kciao.gateways.repositories.EventoRepository;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDataDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDescricaoDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchTipoDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudEvento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudEventoImpl implements CrudEvento {
    private final EventoRepository eventoRepository;
    @Override
    public EventoResponseDto save(EventoRequestPostDto eventoRequestPostDto) {

        Evento eventoASerCriado = Evento.builder()
                .tipo_evento(eventoRequestPostDto.getTipo_evento())
                .desc_evento(eventoRequestPostDto.getDesc_evento())
                .dt_evento(eventoRequestPostDto.getDt_evento())
                .fk_cliente(eventoRequestPostDto.getFk_cliente())
                .build();

        Evento eventoSalvo = eventoRepository.save(eventoASerCriado);

        EventoResponseDto eventoResponse = EventoResponseDto.builder()
                .tipo_evento(eventoSalvo.getTipo_evento())
                .desc_evento(eventoSalvo.getDesc_evento())
                .dt_evento(eventoSalvo.getDt_evento())
                .fk_cliente(eventoSalvo.getFk_cliente())
                .build();

        return eventoResponse;
    }

    @Override
    public Optional<EventoResponseDto> getOne(String id) {
        Optional<Evento> evento = eventoRepository.findById(id);

        if (evento.isPresent()) {
            EventoResponseDto eventoResponse = EventoResponseDto.builder()
                    .tipo_evento(evento.get().getTipo_evento())
                    .desc_evento(evento.get().getDesc_evento())
                    .dt_evento(evento.get().getDt_evento())
                    .fk_cliente(evento.get().getFk_cliente())
                    .build();
            return Optional.of(eventoResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<EventoResponseDto> getAll() {
        List<Evento> listEvento = eventoRepository.findAll();
        List<EventoResponseDto> listEventoResponse = listEvento.stream()
                .map(evento -> EventoResponseDto.builder()
                        .tipo_evento(evento.getTipo_evento())
                        .desc_evento(evento.getDesc_evento())
                        .dt_evento(evento.getDt_evento())
                        .fk_cliente(evento.getFk_cliente())
                        .build()).toList();
        return listEventoResponse;
    }

    @Override
    public Optional<EventoResponseDto> updateData(String id, EventoRequestPatchDataDto eventoRequestPatchDataDto) {

        Evento eventoASerAtualizado = Evento.builder()
                .dt_evento(eventoRequestPatchDataDto.getDt_evento())
                .build();

        int eventoAtualizado = eventoRepository.updateDataById_evento(
                eventoASerAtualizado.getDt_evento(),
                id
        );

        if (eventoAtualizado != 0) {
            Optional<EventoResponseDto> eventoAtualizadoResponse = getOne(id);
            if (eventoAtualizadoResponse.isPresent()) {
                EventoResponseDto eventoResponse = EventoResponseDto.builder()
                        .dt_evento(eventoAtualizadoResponse.get().getDt_evento())
                        .build();
                return Optional.ofNullable(eventoResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<EventoResponseDto> updateDescricao(String id, EventoRequestPatchDescricaoDto eventoRequestPatchDescricaoDto) {

        Evento eventoASerAtualizado = Evento.builder()
                .desc_evento(eventoRequestPatchDescricaoDto.getDesc_evento())
                .build();

        int eventoAtualizado = eventoRepository.updateDescricaoById_evento(
                eventoASerAtualizado.getDesc_evento(),
                id
        );

        if (eventoAtualizado != 0) {
            Optional<EventoResponseDto> eventoAtualizadoResponse = getOne(id);
            if (eventoAtualizadoResponse.isPresent()) {
                EventoResponseDto eventoResponse = EventoResponseDto.builder()
                        .desc_evento(eventoAtualizadoResponse.get().getDesc_evento())
                        .build();
                return Optional.ofNullable(eventoResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<EventoResponseDto> updateTipo(String id, EventoRequestPatchTipoDto eventoRequestPatchTipoDto) {

        Evento eventoASerAtualizado = Evento.builder()
                .tipo_evento(eventoRequestPatchTipoDto.getTipo_evento())
                .build();

        int eventoAtualizado = eventoRepository.updateTipoById_evento(
                eventoASerAtualizado.getTipo_evento(),
                id
        );

        if (eventoAtualizado != 0) {
            Optional<EventoResponseDto> eventoAtualizadoResponse = getOne(id);
            if (eventoAtualizadoResponse.isPresent()) {
                EventoResponseDto eventoResponse = EventoResponseDto.builder()
                        .tipo_evento(eventoAtualizadoResponse.get().getTipo_evento())
                        .build();
                return Optional.ofNullable(eventoResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(String id) {
        eventoRepository.deleteById(id);
    }
}
