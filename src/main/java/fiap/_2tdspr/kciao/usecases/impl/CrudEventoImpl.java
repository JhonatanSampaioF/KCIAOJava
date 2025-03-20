package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Evento;
import fiap._2tdspr.kciao.gateways.controllers.interfaces.EventoController;
import fiap._2tdspr.kciao.gateways.repositories.EventoRepository;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudEvento;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
                .id_evento(eventoSalvo.getId_evento())
                .tipo_evento(eventoSalvo.getTipo_evento())
                .desc_evento(eventoSalvo.getDesc_evento())
                .dt_evento(eventoSalvo.getDt_evento())
                .fk_cliente(eventoSalvo.getFk_cliente())
                .build();

        eventoResponse.add(
                linkTo(
                      methodOn(EventoController.class)
                              .getEvento(eventoSalvo.getId_evento().toString())
                ).withSelfRel()
        );

        return eventoResponse;
    }

    @Override
    public EventoResponseDto getOne(String id) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evento not found"));

        return EventoResponseDto.builder()
                .id_evento(evento.getId_evento())
                .tipo_evento(evento.getTipo_evento())
                .desc_evento(evento.getDesc_evento())
                .dt_evento(evento.getDt_evento())
                .fk_cliente(evento.getFk_cliente())
                .build();
    }

    @Override
    public List<EventoResponseDto> getAll() {
        List<Evento> listEvento = eventoRepository.findAll();
        return listEvento.stream()
                .map(evento -> EventoResponseDto.builder()
                        .id_evento(evento.getId_evento())
                        .tipo_evento(evento.getTipo_evento())
                        .desc_evento(evento.getDesc_evento())
                        .dt_evento(evento.getDt_evento())
                        .fk_cliente(evento.getFk_cliente())
                        .build()).toList();
    }

    @Override
    public EventoResponseDto update(String id, EventoRequestPatchDto eventoRequestPatchDto) {

        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evento not found"));

        evento.setTipo_evento(eventoRequestPatchDto.getTipo_evento() != null ? eventoRequestPatchDto.getTipo_evento() : evento.getTipo_evento());
        evento.setDesc_evento(eventoRequestPatchDto.getDesc_evento() != null ? eventoRequestPatchDto.getDesc_evento() : evento.getDesc_evento());
        evento.setDt_evento(eventoRequestPatchDto.getDt_evento() != null ? eventoRequestPatchDto.getDt_evento() : evento.getDt_evento());

        Evento eventoSalvo = eventoRepository.save(evento);

        return EventoResponseDto.builder()
                .tipo_evento(eventoSalvo.getTipo_evento())
                .desc_evento(eventoSalvo.getDesc_evento())
                .dt_evento(eventoSalvo.getDt_evento())
                .build();
    }

//    @Override
//    public EventoResponseDto updateData(String id, EventoRequestPatchDataDto eventoRequestPatchDataDto) {
//
//        Evento eventoASerAtualizado = Evento.builder()
//                .dt_evento(eventoRequestPatchDataDto.getDt_evento())
//                .build();
//
//        int eventoAtualizado = eventoRepository.updateDataById_evento(
//                eventoASerAtualizado.getDt_evento(),
//                id
//        );
//
//        if (eventoAtualizado != 0) {
//            EventoResponseDto eventoAtualizadoResponse = getOne(id);
//            if (eventoAtualizadoResponse.isPresent()) {
//                EventoResponseDto eventoResponse = EventoResponseDto.builder()
//                        .dt_evento(eventoAtualizadoResponse.get().getDt_evento())
//                        .build();
//                return ofNullableeventoResponse);
//            }
//            return empty);
//        } else {
//            return empty);
//        }
//    }
//
//    @Override
//    public EventoResponseDto updateDescricao(String id, EventoRequestPatchDescricaoDto eventoRequestPatchDescricaoDto) {
//
//        Evento eventoASerAtualizado = Evento.builder()
//                .desc_evento(eventoRequestPatchDescricaoDto.getDesc_evento())
//                .build();
//
//        int eventoAtualizado = eventoRepository.updateDescricaoById_evento(
//                eventoASerAtualizado.getDesc_evento(),
//                id
//        );
//
//        if (eventoAtualizado != 0) {
//            EventoResponseDto eventoAtualizadoResponse = getOne(id);
//            if (eventoAtualizadoResponse.isPresent()) {
//                EventoResponseDto eventoResponse = EventoResponseDto.builder()
//                        .desc_evento(eventoAtualizadoResponse.get().getDesc_evento())
//                        .build();
//                return ofNullableeventoResponse);
//            }
//            return empty);
//        } else {
//            return empty);
//        }
//    }
//
//    @Override
//    public EventoResponseDto updateTipo(String id, EventoRequestPatchTipoDto eventoRequestPatchTipoDto) {
//
//        Evento eventoASerAtualizado = Evento.builder()
//                .tipo_evento(eventoRequestPatchTipoDto.getTipo_evento())
//                .build();
//
//        int eventoAtualizado = eventoRepository.updateTipoById_evento(
//                eventoASerAtualizado.getTipo_evento(),
//                id
//        );
//
//        if (eventoAtualizado != 0) {
//            EventoResponseDto eventoAtualizadoResponse = getOne(id);
//            if (eventoAtualizadoResponse.isPresent()) {
//                EventoResponseDto eventoResponse = EventoResponseDto.builder()
//                        .tipo_evento(eventoAtualizadoResponse.get().getTipo_evento())
//                        .build();
//                return ofNullableeventoResponse);
//            }
//            return empty);
//        } else {
//            return empty);
//        }
//    }

    @Override
    public void delete(String id) {
        eventoRepository.deleteById(id);
    }
}
