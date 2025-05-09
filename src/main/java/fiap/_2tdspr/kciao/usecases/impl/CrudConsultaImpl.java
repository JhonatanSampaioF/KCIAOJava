package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.domains.Consulta;
import fiap._2tdspr.kciao.domains.Evento;
import fiap._2tdspr.kciao.gateways.controllers.interfaces.ConsultaController;
import fiap._2tdspr.kciao.gateways.repositories.ClienteRepository;
import fiap._2tdspr.kciao.gateways.repositories.ConsultaRepository;
import fiap._2tdspr.kciao.gateways.repositories.EventoRepository;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudConsulta;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class CrudConsultaImpl implements CrudConsulta {
    private final ConsultaRepository consultaRepository;
    private final ClienteRepository clienteRepository;
    private final EventoRepository eventoRepository;

    @Override
    public ConsultaResponseDto save(ConsultaRequestPostDto consultaRequestPostDto) {

        Consulta consultaASerCriada = Consulta.builder()
                .profissional(consultaRequestPostDto.getProfissional())
                .local_consulta(consultaRequestPostDto.getLocal_consulta())
                .horario_consulta(consultaRequestPostDto.getHorario_consulta())
                .fk_evento(consultaRequestPostDto.getFk_evento())
                .build();

        Consulta consultaSalva = consultaRepository.save(consultaASerCriada);

        ConsultaResponseDto consultaResponse = ConsultaResponseDto.builder()
                .id_consulta(consultaSalva.getId_consulta())
                .profissional(consultaSalva.getProfissional())
                .local_consulta(consultaSalva.getLocal_consulta())
                .horario_consulta(consultaSalva.getHorario_consulta())
                .fk_evento(consultaSalva.getFk_evento())
                .build();

        consultaResponse.add(
                linkTo(
                        methodOn(ConsultaController.class)
                                .getConsulta(consultaSalva.getId_consulta().toString())
                ).withSelfRel()
        );

        return consultaResponse;
    }

    @Override
    public ConsultaResponseDto saveWithEvento(ConsultaWithEventoRequestPostDto consultaWithEventoPostDto) {
        Cliente cliente = clienteRepository.findById(consultaWithEventoPostDto.getFk_cliente()).orElseThrow(() -> new EntityNotFoundException("Client not found"));

        Evento evento = Evento.builder()
                .tipo_evento("Consulta")
                .desc_evento(consultaWithEventoPostDto.getDesc_evento())
                .dt_evento(consultaWithEventoPostDto.getDt_evento())
                .fk_cliente(cliente)
                .build();

        Evento eventoSalvo = eventoRepository.save(evento);

        Consulta consulta = Consulta.builder()
                .profissional(consultaWithEventoPostDto.getProfissional())
                .local_consulta(consultaWithEventoPostDto.getLocal_consulta())
                .horario_consulta(consultaWithEventoPostDto.getHorario_consulta())
                .fk_evento(eventoSalvo)
                .build();

        Consulta consultaSalva = consultaRepository.save(consulta);

        return ConsultaResponseDto.builder()
                .id_consulta(consultaSalva.getId_consulta())
                .profissional(consultaSalva.getProfissional())
                .local_consulta(consultaSalva.getLocal_consulta())
                .horario_consulta(consultaSalva.getHorario_consulta())
                .build();
    }

    @Override
    public ConsultaResponseDto getOne(String id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta not found"));

        return ConsultaResponseDto.builder()
                .id_consulta(consulta.getId_consulta())
                .profissional(consulta.getProfissional())
                .local_consulta(consulta.getLocal_consulta())
                .horario_consulta(consulta.getHorario_consulta())
                .fk_evento(consulta.getFk_evento())
                .build();
    }

    @Override
    public List<ConsultaResponseDto> getAll() {
        List<Consulta> listConsulta = consultaRepository.findAll();
        return listConsulta.stream()
                .map(consulta -> ConsultaResponseDto.builder()
                        .id_consulta(consulta.getId_consulta())
                        .profissional(consulta.getProfissional())
                        .local_consulta(consulta.getLocal_consulta())
                        .horario_consulta(consulta.getHorario_consulta())
                        .build()).toList();
    }

    @Override
    public ConsultaResponseDto update(String id, ConsultaRequestPatchDto consultaRequestPatchDto) {

        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta not found"));

        consulta.setHorario_consulta(consultaRequestPatchDto.getHorario_consulta() != null ? consultaRequestPatchDto.getHorario_consulta() : consulta.getHorario_consulta());
        consulta.setLocal_consulta(consultaRequestPatchDto.getLocal_consulta() != null ? consultaRequestPatchDto.getLocal_consulta() : consulta.getLocal_consulta());
        consulta.setProfissional(consultaRequestPatchDto.getProfissional() != null ? consultaRequestPatchDto.getProfissional() : consulta.getProfissional());

        Consulta consultaSalva = consultaRepository.save(consulta);

        return  ConsultaResponseDto.builder()
                .id_consulta(consultaSalva.getId_consulta())
                .horario_consulta(consultaSalva.getHorario_consulta())
                .local_consulta(consultaSalva.getLocal_consulta())
                .profissional(consultaSalva.getProfissional())
                .build();
    }

    @Override
    public ConsultaResponseDto updateWithEvento(String id, ConsultaWithEventoRequestPatchDto consultaWithEventoRequestPatchDto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta not found"));
        Evento evento = eventoRepository.findById(consulta.getFk_evento().getId_evento())
                .orElseThrow(() -> new EntityNotFoundException("Evento not found"));

        consulta.setHorario_consulta(consultaWithEventoRequestPatchDto.getHorario_consulta() != null ? consultaWithEventoRequestPatchDto.getHorario_consulta() : consulta.getHorario_consulta());
        consulta.setLocal_consulta(consultaWithEventoRequestPatchDto.getLocal_consulta() != null ? consultaWithEventoRequestPatchDto.getLocal_consulta() : consulta.getLocal_consulta());
        consulta.setProfissional(consultaWithEventoRequestPatchDto.getProfissional() != null ? consultaWithEventoRequestPatchDto.getProfissional() : consulta.getProfissional());

        Consulta consultaSalva = consultaRepository.save(consulta);

        evento.setDt_evento(consultaWithEventoRequestPatchDto.getDt_evento() != null ? consultaWithEventoRequestPatchDto.getDt_evento() : evento.getDt_evento());
        evento.setDesc_evento(consultaWithEventoRequestPatchDto.getDesc_evento() != null ? consultaWithEventoRequestPatchDto.getDesc_evento() : evento.getDesc_evento());

        eventoRepository.save(evento);

        return  ConsultaResponseDto.builder()
                .id_consulta(consultaSalva.getId_consulta())
                .horario_consulta(consultaSalva.getHorario_consulta())
                .local_consulta(consultaSalva.getLocal_consulta())
                .profissional(consultaSalva.getProfissional())
                .build();
    }

    @Override
    public void delete(String id) {
        consultaRepository.deleteById(id);
    }
}
