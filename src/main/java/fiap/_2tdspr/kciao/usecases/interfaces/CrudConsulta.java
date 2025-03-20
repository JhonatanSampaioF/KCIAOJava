package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaWithEventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.evento.EventoRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudConsulta {
    ConsultaResponseDto save(ConsultaRequestPostDto consultaRequestPostDto);
    ConsultaResponseDto saveWithEvento(ConsultaWithEventoRequestPostDto consultaWithEventoPostDto);
    ConsultaResponseDto getOne(String id);
    List<ConsultaResponseDto> getAll();
    ConsultaResponseDto update(String id, ConsultaRequestPatchDto consultaRequestPatchDto);
    ConsultaResponseDto updateWithEvento(String id, ConsultaWithEventoRequestPatchDto consultaWithEventoRequestPatchDto);
    void delete(String id);
}
