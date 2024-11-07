package fiap._2tdspr.kciao.gateways.controllers.interfaces;

import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public interface ConsultaController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<ConsultaResponseDto>> getConsulta(@PathVariable @Valid String id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ConsultaResponseDto>> getAllConsulta();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ConsultaResponseDto> criarConsulta(@RequestBody @Valid ConsultaRequestPostDto consulta);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Optional<ConsultaResponseDto>> atualizarConsulta(@PathVariable @Valid String id, @RequestBody @Valid ConsultaRequestPatchDto consultaRequestPatchDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletarConsulta(@PathVariable @Valid String id);
}