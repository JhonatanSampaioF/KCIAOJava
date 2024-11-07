package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
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
    Optional<ConsultaResponseDto> update(String id, ConsultaRequestPatchDto consultaRequestPatchDto);
    void delete(String id);
}
