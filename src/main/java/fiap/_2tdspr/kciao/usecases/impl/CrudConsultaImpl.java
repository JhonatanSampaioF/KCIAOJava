package fiap._2tdspr.kciao.usecases.impl;

import fiap._2tdspr.kciao.domains.Consulta;
import fiap._2tdspr.kciao.gateways.repositories.ConsultaRepository;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchHorarioDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchLocalDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchProfissionalDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import fiap._2tdspr.kciao.usecases.interfaces.CrudConsulta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudConsultaImpl implements CrudConsulta {
    private final ConsultaRepository consultaRepository;
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
                .profissional(consultaSalva.getProfissional())
                .local_consulta(consultaSalva.getLocal_consulta())
                .horario_consulta(consultaSalva.getHorario_consulta())
                .fk_evento(consultaSalva.getFk_evento())
                .build();

        return consultaResponse;
    }

    @Override
    public Optional<ConsultaResponseDto> getOne(String id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);

        if (consulta.isPresent()) {
            ConsultaResponseDto consultaResponse = ConsultaResponseDto.builder()
                    .profissional(consulta.get().getProfissional())
                    .local_consulta(consulta.get().getLocal_consulta())
                    .horario_consulta(consulta.get().getHorario_consulta())
                    .fk_evento(consulta.get().getFk_evento())
                    .build();
            return Optional.of(consultaResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<ConsultaResponseDto> getAll() {
        List<Consulta> listConsulta = consultaRepository.findAll();
        List<ConsultaResponseDto> listConsultaResponse = listConsulta.stream()
                .map(consulta -> ConsultaResponseDto.builder()
                        .profissional(consulta.getProfissional())
                        .local_consulta(consulta.getLocal_consulta())
                        .horario_consulta(consulta.getHorario_consulta())
                        .build()).toList();
        return listConsultaResponse;
    }

    @Override
    public Optional<ConsultaResponseDto> updateHorario(String id, ConsultaRequestPatchHorarioDto consultaRequestPatchHorarioDto) {

        Consulta consultaASerAtualizada = Consulta.builder()
                .horario_consulta(consultaRequestPatchHorarioDto.getHorario_consulta())
                .build();

        int consultaAtualizada = consultaRepository.updateHorarioById_consulta(
                consultaASerAtualizada.getHorario_consulta(),
                id
        );

        if(consultaAtualizada != 0) {
            Optional<ConsultaResponseDto> consultaAtualizadaResponse = getOne(id);
            if(consultaAtualizadaResponse.isPresent()) {
                ConsultaResponseDto consultaResponse = ConsultaResponseDto.builder()
                        .horario_consulta(consultaAtualizadaResponse.get().getHorario_consulta())
                        .build();
                return Optional.ofNullable(consultaResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ConsultaResponseDto> updateLocal(String id, ConsultaRequestPatchLocalDto consultaRequestPatchLocalDto) {

        Consulta consultaASerAtualizada = Consulta.builder()
                .local_consulta(consultaRequestPatchLocalDto.getLocal_consulta())
                .build();

        int consultaAtualizada = consultaRepository.updateLocalById_consulta(
                consultaASerAtualizada.getLocal_consulta(),
                id
        );

        if(consultaAtualizada != 0) {
            Optional<ConsultaResponseDto> consultaAtualizadaResponse = getOne(id);
            if(consultaAtualizadaResponse.isPresent()) {
                ConsultaResponseDto consultaResponse = ConsultaResponseDto.builder()
                        .local_consulta(consultaAtualizadaResponse.get().getLocal_consulta())
                        .build();
                return Optional.ofNullable(consultaResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ConsultaResponseDto> updateProfissional(String id, ConsultaRequestPatchProfissionalDto consultaRequestPatchProfissionalDto) {

        Consulta consultaASerAtualizada = Consulta.builder()
                .profissional(consultaRequestPatchProfissionalDto.getProfissional())
                .build();

        int consultaAtualizada = consultaRepository.updateProfissionalById_consulta(
                consultaASerAtualizada.getProfissional(),
                id
        );

        if(consultaAtualizada != 0) {
            Optional<ConsultaResponseDto> consultaAtualizadaResponse = getOne(id);
            if(consultaAtualizadaResponse.isPresent()) {
                ConsultaResponseDto consultaResponse = ConsultaResponseDto.builder()
                        .profissional(consultaAtualizadaResponse.get().getProfissional())
                        .build();
                return Optional.ofNullable(consultaResponse);
            }
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(String id) {
        consultaRepository.deleteById(id);
    }
}
