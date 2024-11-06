package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchHorarioDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchLocalDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchProfissionalDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudConsulta {
    ConsultaResponseDto save(ConsultaRequestPostDto consultaRequestPostDto);
    Optional<ConsultaResponseDto> getOne(String id);
    List<ConsultaResponseDto> getAll();
    Optional<ConsultaResponseDto> updateHorario(String id, ConsultaRequestPatchHorarioDto consultaRequestPatchHorarioDto);
    Optional<ConsultaResponseDto> updateLocal(String id, ConsultaRequestPatchLocalDto consultaRequestPatchLocalDto);
    Optional<ConsultaResponseDto> updateProfissional(String id, ConsultaRequestPatchProfissionalDto consultaRequestPatchProfissionalDto);
    void delete(String id);
}
